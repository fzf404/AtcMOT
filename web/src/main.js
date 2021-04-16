import Vue from 'vue'
import App from './App.vue'
import store from './store'

import dataV from '@jiaminghi/data-view'

import './assets/common.less'

Vue.config.productionTip = false

Vue.use(dataV)

new Vue({
  store,
  render: h => h(App)
}).$mount('#app')
