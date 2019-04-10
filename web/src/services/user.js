import axios from 'axios'

export const user = {
  login,
  logout
}

function login (username, password) {
  return axios.post(`http://localhost:8080/user/login`, {username: username, password: password})
    .then(handleResponse)
    .then(data => {
      if (data.token) {
        localStorage.setItem('user', JSON.stringify(data.token))
        return data.token
      }
    })
}

function logout () {
  localStorage.removeItem('user')
}

function handleResponse (response) {
  if (!(response.status >= 200 && response.status <= 299)) {
    if (response.status === 401) {
      logout()
      location.reload(true)
    }
    const error = response.statusText
    return Promise.reject(error)
  }
  return response.data
}
