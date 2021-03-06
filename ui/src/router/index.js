import Vue from 'vue'
import Router from 'vue-router'
import Guests from '@/components/Guests'
import Tables from '@/components/Tables'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Guests',
      component: Guests
    },
    {
      path: '/tables',
      name: 'Tables',
      component: Tables
    }
  ]
})
