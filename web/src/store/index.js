import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

const API_BASE = 'http://39.106.106.202:8080/api'

Vue.use(Vuex)

export default new Vuex.Store({
  // 只有mutations能修改state的值
  // strict: true,
  // 全部数据
  state: {
    total: 231,
    rflag: false,
    tflag: true,
    timeName: ['12:00', '12:01', '12:02', '12:03', '12:04', '12:05'],
    timeData: [23, 18, 16, 14, 10, 8],
    rtmpURL: 'http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8',
    personData: {},
    crimeURL: []
    // personLabel: [],
    // perosonPos: [],
  },
  // 修改state值的函数
  mutations: {
    CAHNGE (state, payload) {
      // 更新人数值
      let timeName = []
      let timeData = []
      for (let key in payload.res.time) {
        timeName.push(key)
        timeData.push(payload.res.time[key])
      }
      // let personLabel = []
      // let personPos = []
      // for (let key in payload.res.fdata['fdata']) {
      //   personLabel.push(key)
      //   personPos.push(payload.res.fdata['fdata'][key])
      // }
      state.timeName = timeName
      state.timeData = timeData
      // state.personLabel = personLabel
      // state.perosonPos = personPos
      state.personData = payload.res.fdata['fdata']
      state.total = payload.res.total
      state.rtmpURL = payload.res.fdata['rtmp']
      payload.res.crime.forEach((item, index) => {
        state.crimeURL[index] = 'http://39.106.106.202/crime' + item
        document.getElementById('img' + String(index)).src = state.crimeURL[index]
      })
    }
  },
  // 异步操作
  actions: {
    getActive ({ commit }) {
      // 发送异步请求
      axios.get(`${API_BASE}/active?rflag=${this.state.rflag}&cid=1`).then(response => {
        // 再次调用mutations
        commit('CAHNGE', {
          res: response.data
        })
      })
    }
  }
})
