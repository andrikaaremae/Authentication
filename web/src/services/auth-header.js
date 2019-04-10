export default function authHeader () {
  if (localStorage.getItem('user') != null) {
    let user = localStorage.getItem('user')
    let token = user.replace(/"/g, '') // it has quote marks for some reason
    return { 'Authorization': 'Bearer ' + token }
  } else {
    return {}
  }
}
