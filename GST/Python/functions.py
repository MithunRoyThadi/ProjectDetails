import json
import requests 
import os

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
	
def createJson(params: dict):
	#data
	jsonData	=	params["JsonData"]

	#lst elements
	lstFileBase = "../LSTFileBase/LSTData/"
	lstInfo	=	params["LSTInfo"]
	lstType	=	lstInfo["LSTType"]
	
	#file base elements
	if lstType == "File":
		folderName = lstFileBase+lstInfo["Collection"]
		fileName   = lstInfo["Document"]
		print("File")
	
	#Authentication info
	userName   = lstInfo["UserName"]
	password   = lstInfo["PassWord"]
	autoGenerate = lstInfo["AutoGenerate"]
	
	#transaction info
	overWrite  = lstInfo["OverWrite"]
	batchId    = lstInfo["BatchId"]
	
	if lstType == "File":
		os.makedirs(folderName)
		with open(folderName+"/"+fileName,'w+') as workingFile:
			json.dump(jsonData,workingFile)
			workingFile.close()
		print("test")
	return jsonData