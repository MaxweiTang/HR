import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import './plugins/element.js'
import axios from 'axios';
import qs from 'qs';


axios.defaults.baseURL = 'http://111.230.107.69:8081/HR';// 配置接口地址
axios.defaults.withCredentials = false;

Vue.prototype.$axios = axios;
Vue.prototype.$qs = qs;

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
