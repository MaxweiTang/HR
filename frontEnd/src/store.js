import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userToken: '',
    identity: ''
  },
  mutations: {
    setUserMsg(state,userToken,identity){
      state.userToken = userToken;
      state.identity = identity;
    }
  },
  getters:{
    getUserToken(state) {
      return state.userToken;
    },
    getIdentity(state){
      return state.identity;
    }
  }
  // actions: {}
});
