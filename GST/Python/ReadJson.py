import json
import requests 
# read file
with open('example.json', 'r') as myfile:
    data=myfile.read()

# parse file
obj = json.loads(data)

# show values
print("Invoice Number: " + str(obj['Invoice_number']))
print("Total Taxable: " + str(obj['Taxable value']))
print("CGST : " + str(obj['CGST']))
print("SGST : " + str(obj['SGST']))
print("Total Value : " + str(obj['Item details']))

#res = requests.get("https://172.17.0.177:8090/MQMFT-RestService/hosts") 
#var = json.loads(res.text)
#print("eur: " + str(obj['eur']))
#print("gbp: " + str(obj['gbp']))