import os

import _init_paths
from opts import opts
from tracking_utils.utils import mkdir_if_missing
import datasets.dataset.jde as datasets
from track import eval_seq

def recogniton(opt):

    print("start tracking")
    if opt.input_stream == '':
        dataloader = datasets.LoadVideo(opt.input_camera, opt.img_size)
    else:
        dataloader = datasets.LoadVideo(opt.input_stream, opt.img_size)

    frame_rate = dataloader.frame_rate

    if opt.save:
        result_root = opt.output_root if opt.output_root != '' else '.'
        mkdir_if_missing(result_root)
        result_filename = os.path.join(result_root, 'results.txt')
        frame_dir = None if opt.output_format == 'text' else os.path.join(
            result_root, 'frame')
        eval_seq(opt, dataloader, 'mot', result_filename,
                 save_dir=frame_dir, show_image=opt.show, frame_rate=frame_rate,
                 use_cuda=opt.gpus != [-1])
    else:
        eval_seq(opt, dataloader, 'mot', show_image=opt.show,
                 frame_rate=frame_rate, use_cuda=opt.gpus != [-1])


if __name__ == '__main__':
    os.environ['CUDA_VISIBLE_DEVICES'] = '0'
    opt = opts().init()
    recogniton(opt)
