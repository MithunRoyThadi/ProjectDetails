from flask import Flask
from flask import request

import functions

app = Flask(__name__)


@app.route('/call/<function_name>', methods=[ 'POST', 'PUT', 'DELETE'])
def call_function(function_name: str):
    function_to_call = getattr(functions, function_name)
    body = request.json
    return function_to_call(body)

#route rest link for get functions
@app.route('/<function_name>', methods=['GET'])
def get_function(function_name: str):
    function_to_call = getattr(functions, function_name)
    
    return function_to_call()
	
app.run(host="172.17.3.30")
