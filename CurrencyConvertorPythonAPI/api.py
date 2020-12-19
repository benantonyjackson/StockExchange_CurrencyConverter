from flask import Flask
from flask import Response
from flask import jsonify

import requests
import json

BASE_URL = "http://data.fixer.io/api"
API_KEY = "ad056783a6a38055946311f0eb3a79e2"
BASE_CURRENCY = 'EUR'

app = Flask(__name__)


def save_rates_to_file(data, file_name="rates.json"):
    file = open(file_name, "w")

    file.write(json.dumps(data))


def get_default_response(body={}):
    res = Response()
    res.headers['Content-type'] = "application/json"
    res.response = json.dumps(body)
    return res


@app.route("/convert", methods=["GET"])
def convert():
    res = requests.get(BASE_URL + "/latest", params={'access_key': API_KEY})
    save_rates_to_file(res.text)
    return Response(res.text, headers={"Content-type": "application/json"})


@app.route("/get_all_currencies")
def get_all_currencies():
    res = requests.get(BASE_URL + "/symbols", params={'access_key': API_KEY})

    list_of_currency_codes = json.loads(res.text)

    return get_default_response({"all_currencies": list(list_of_currency_codes['results'].keys())})


if __name__ == "__main__":
    app.run()
