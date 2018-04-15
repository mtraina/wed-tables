import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Guests from '@/components/Guests'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Guests',
      component: Guests
    },
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
