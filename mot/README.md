
# AtcMOT

> 使用FairMOT开发的ATC目标跟踪

<a href="https://colab.research.google.com/drive/1cWBSXTHZQfauG1jSSVF8QthIbnWbfxm8?usp=sharing"><img src="https://colab.research.google.com/assets/colab-badge.svg" alt="Open In Colab"></a>

## 运行说明
```bash 
# <说明> [默认值]
python atc.py mot --input-stream <输入视频流> []
					--url <发送帧请求接口地址> []
					--device-id <设备号> [1]
					--trigger <违法判断参数> [230]
					--check-setp <违法检测间隔帧数>	[3]

					
					--input-camera <输入摄像头设备号> [0]
					--show <True/False展示运算结果>	[False]
					--save <True/False保存>	[False]
```

## 
```bash
# 运行示例
python demo.py mot --trigger 200		
# 使用本地摄像头
python atc.py mot --input-camera 0
# 启动服务
python atc.py mot --input-stream http://xxx.top/atc/test.m3u8?auth_key=1617623448-0-0-a09635314506eb7413425a0c8d7aa34e \
					--url http://ip:3000 \
					--device-id 1 \
					--trigger 250 \
					--check-setp 5 \
```