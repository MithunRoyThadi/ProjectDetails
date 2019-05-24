import json
import requests 

def hello_world():
    return "Hello world!"


def writeJson(params: dict):
    name = params["name"]
    return "Hello " + name
	
def getGSTValues():
	# read file
	with open('example.json', 'r') as myfile:
		data=myfile.read()

	# parse file
	obj = json.loads(data)
	return str(obj)