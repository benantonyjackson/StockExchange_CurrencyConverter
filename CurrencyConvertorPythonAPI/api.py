from flask import Flask
from flask import Response
from flask import jsonify

import requests
import json

app = Flask(__name__)


def get_default_response(body={}):
    res = Response()
    res.headers['Content-type'] = "application/json"
    res.response = json.dumps(body)
    return res


@app.route("/convert", methods=["GET"])
def convert():
    return get_default_response({"Message": "It worked"})


if __name__ == "__main__":
    app.run()
