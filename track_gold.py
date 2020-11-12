import datetime, sched, time, json, requests

out_file = open('./data/gold_rates.csv','a')
def store_rate():
	try:
		response = requests.get("https://www.motilaloswal.com/marketapi/index.php/investpage/megold/rates")
		print(datetime.datetime.now().strftime("%d-%m-%y %H:%M:%S")+','+str(response.json()['buyPostTax']),file=out_file)
	except:
		print(datetime.datetime.now().strftime("%d-%m-%y %H:%M:%S")+',',file=out_file)
	out_file.flush()

while True:
	store_rate()
	time.sleep(300)

out_file.close()