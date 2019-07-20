import Vue from "vue";
import Router from "vue-router";
import login from "./views/login.vue";
import home from "./views/home.vue";
import personal from "./components/personal.vue";
import index from "./components/index.vue";
import fileManage from "./components/fileManage.vue";
import contractManage from "./components/contractManage.vue";
import transfer from "./components/transfer.vue";
import attendance from "./components/attendance.vue";
import recruit from "./components/recruit.vue";
import trainingRecords from "./components/trainingRecords.vue";

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
        name: "首页",
        component: index,
      },{
        path: "/fileManage",
        name: "档案管理",
        component: fileManage,
      },{
        path: "/contractManage",
        name: "合同管理",
        component: contractManage,
      },{
        path: "/transfer",
        name: "人事调动",
        component: transfer,
      },{
        path: "/attendance",
        name: "考勤管理",
        component: attendance,
      },
      {
        path: "/recruit",
        name: "招聘记录",
        component: recruit,
      },
      {
        path: "/trainingRecords",
        name: "培训记录",
        component: trainingRecords,
      }
    ]
    }
  ]
});