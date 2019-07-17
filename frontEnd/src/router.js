import Vue from "vue";
import Router from "vue-router";
import login from "./views/login.vue";
import home from "./views/home.vue";
import personal from "./components/personal.vue";
import index from "./components/index.vue";
import fileManage from "./components/fileManage.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "login",
      component: login
    },
    {
      path: "/home",
      name: "home",
      component: home,
      redirect: '/index',
      children: [{
        path: "/personal",
        name: "personal",
        component: personal,
      },{
        path: "/index",
        name: "index",
        component: index,
      },{
        path: "/fileManage",
        name: "fileManage",
        component: fileManage,
      }]
    }
  ]
});