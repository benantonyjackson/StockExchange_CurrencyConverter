from flask import Flask
from flask import Response
from flask import jsonify

import requests
import json

BASE_URL = "https://free.currconv.com"
API_KEY = "809e6007e713ca1b8fd6"

app = Flask(__name__)


def get_default_response(body={}):
    res = Response()
    res.headers['Content-type'] = "application/json"
    res.response = json.dumps(body)
    return res


@app.route("/convert", methods=["GET"])
def convert():
    return get_default_response({"Message": "It worked"})


@app.route("/get_all_currencies")
def get_all_currencies():
    res = requests.get(BASE_URL + "/api/v7/currencies", params={'apiKey': API_KEY})

    list_of_currency_codes = json.loads(res.text)

    return get_default_response({"all_currencies": list(list_of_currency_codes['results'].keys())})


if __name__ == "__main__":
    app.run()
