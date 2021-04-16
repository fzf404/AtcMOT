import cv2
import atcs


def handle_img(info, img):
    img_clip = img[int(info[1]):int(info[1]+info[3]),
                   int(info[0]):int(info[0]+info[2])]
    return img_clip


class PersonMOT():
    def __init__(self):
        self.record = []
        self.count = 1

    def handle_crime(self, cid, url, trigger, fid, finfo, img):
        # trigger： x1, y1, w, h
        for index, info in enumerate(finfo):
            if info[3] > trigger and (fid[index] not in self.record):
                # 图像裁切
                img_clip = handle_img(info, img)
                img_path = '../results/cache-' + str(self.count)+'.jpg'
                # 图片上传
                cv2.imwrite(img_path, img_clip)
                atcs.send_crime(cid,url,self.count,img_path)
                # 更新保存表
                self.record.append(fid[index])
                self.count += 1