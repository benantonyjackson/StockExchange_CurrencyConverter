from flask import Flask
from flask import Response
from flask import jsonify

import requests
import json

BASE_URL = "http://data.fixer.io/api"
API_KEY = "ad056783a6a38055946311f0eb3a79e2"
BASE_CURRENCY = 'EUR'
RATES_FILE_NAME = "rates.json"
LIST_OF_CURRENCIES_FILENAME = "currencies.json"

app = Flask(__name__)


def save_json_to_file(data, file_name):
    file = open(file_name, "w")

    json.dump(data, file)


def read_json_from_file(filename):
    file = open(filename, "r")
    return json.load(file)


def get_default_response(body):
    res = Response()
    res.headers['Content-type'] = "application/json"

    if type(body) is str:
        res.data = body

    elif type(body) is dict:
        res.data = json.dumps(body)

    return res


@app.route("/convert", methods=["GET"])
def convert():
    try:
        res = requests.get(BASE_URL + "/latest", params={'access_key': API_KEY})
        if res.json()['success']:
            save_json_to_file(res.json(), RATES_FILE_NAME)
            return get_default_response(res.text)
        else:
            raise requests.RequestException
    except requests.RequestException:
        try:
            body = read_json_from_file(RATES_FILE_NAME)
            body['message'] = "Up to date list of currencies could not be fetched"
            return get_default_response(body)
        except FileNotFoundError:
            return get_default_response({"Message": "No connection available. And backup file cannot be found"})
    except:
        get_default_response({"Message": "An error occurred"})


@app.route("/get_all_currencies")
def get_all_currencies():
    try:
        res = requests.get(BASE_URL + "/symbols", params={'access_key': API_KEY})

        if res.json()['success']:
            list_of_currency_codes = json.loads(res.text)
            save_json_to_file({"all_currencies": list(list_of_currency_codes['symbols'].keys())}, LIST_OF_CURRENCIES_FILENAME)
            return get_default_response({"all_currencies": list(list_of_currency_codes['symbols'].keys())})
        else:
            raise requests.RequestException
    except requests.RequestException:
        try:
            body = read_json_from_file(LIST_OF_CURRENCIES_FILENAME)
            body['message'] = "Up to date list of currencies could not be fetched"
            return get_default_response(body)
        except FileNotFoundError:
            return get_default_response({"Message": "No connection available, and backup file cannot be found"})
    except:
        get_default_response({"Message": "An error occurred"})


if __name__ == "__main__":
    app.run()
