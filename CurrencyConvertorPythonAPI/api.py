from flask import Flask
from flask import Response
from flask import jsonify

import requests
import json

BASE_URL = "http://data.fixer.io/api"
API_KEY = "ad056783a6a38055946311f0eb3a79e2"
BASE_CURRENCY = 'EUR'
RATES_FILE_NAME = "rates.json"

app = Flask(__name__)


def save_rates_to_file(data, file_name=RATES_FILE_NAME):
    file = open(file_name, "w")

    file.write(json.dumps(data))
    file.close()


def read_rates_from_file(filename=RATES_FILE_NAME):
    file = open(filename, "r")

    return json.loads(file.read())


def get_default_response(body):
    res = Response()
    res.headers['Content-type'] = "application/json"
    res.response = body
    return res


@app.route("/convert", methods=["GET"])
def convert():
    res = requests.get(BASE_URL + "/latest", params={'access_key': API_KEY})
    print(str(res.json()['success']) + str(type(res.json()['success'])))
    if res.json()['success']:
        print("Success")
        save_rates_to_file(res.text)
        return get_default_response(res.text)
    else:
        return get_default_response(read_rates_from_file())


@app.route("/get_all_currencies")
def get_all_currencies():
    res = requests.get(BASE_URL + "/symbols", params={'access_key': API_KEY})

    list_of_currency_codes = json.loads(res.text)

    return get_default_response({"all_currencies": list(list_of_currency_codes['results'].keys())})


if __name__ == "__main__":
    app.run()
