import requests
import json


#
def send_info(cid, url, fid, finfo, rtmp):

    headers = {'Content-Type': 'application/json'}
    url = url + '/api/frame'

    # 信息处理
    info_list = list(map(lambda i: i.tolist(), finfo))
    fdata = {fid[i]: info_list[i] for i in range(len(fid))}
    data = {'cid': cid, 'rtmp': rtmp, 'fdata': fdata}
    # 发送请求
    r = requests.post(url, headers=headers, data=json.dumps(data))
    print(r.text[:64])
    # print(r.text)
    return json.loads(r.text).get('rflag')


def send_crime(cid, url, pid, photo):
    url = url + '/api/crime'
    data = {'cid': cid, 'pid': pid}
    files = {'photo': open(photo, 'rb')}
    r = requests.post(url=url,data=data,files=files)
    print(r.text)

''' 示例请求
{
    "cid": 1, 
    "fdata": {
        "1": [
            493.53204345703125, 
            68.95710754394531, 
            60.2760009765625, 
            165.18812561035156
        ], 
        "5": [
            1798.7884521484375, 
            203.35440063476562, 
            60.57849121093751, 
            173.3409423828125
        ], 
        "6": [
            1314.0870361328125, 
            480.5364685058594, 
            81.9613037109375, 
            221.36410522460938
        ]
    }
}
'''
