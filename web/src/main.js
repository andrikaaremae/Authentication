// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VeeValidate from 'vee-validate'
import App from './App'
import router from './router'
import Vuex from 'vuex'
import * as axios from 'axios'
import store from './store'
import authHeader from './services/auth-header.js'

axios.defaults.withCredentials = true
axios.defaults.headers.common = authHeader()

Vue.config.productionTip = false
Vue.use(VeeValidate)
Vue.use(Vuex)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
