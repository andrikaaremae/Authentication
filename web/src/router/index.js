import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import About from '@/components/About'
import RegistrationPage from '@/components/RegistrationPage'
import LoginPage from '../components/LoginPage'
Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
      path: '/register',
      name: 'Register',
      component: RegistrationPage
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginPage
    }
  ]
})

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register', '/about']
  const authRequired = !publicPages.includes(to.path)
  const loggedIn = localStorage.getItem('user')

  if (authRequired && !loggedIn) {
    return next('/login')
  }

  next()
})

export default router
