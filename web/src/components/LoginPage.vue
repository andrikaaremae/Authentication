<template>
    <div class="modal">
      <h1>Login</h1>
      <form id="loginForm" @submit.prevent="handleSubmit">
        <label>
          Username
          <input type="text" name="username" v-model="username" required>
        </label>
        <label>
          Password
          <input type="password" name="password" v-model="password" required>
        </label>
        <button :disabled='errors.any()' type="submit" class="loginButton">Login</button>
      </form>
    </div>
</template>

<script>

export default {
  data () {
    return {
      username: '',
      password: '',
      submitted: false
    }
  },
  computed: {
    loggingIn () {
      return this.$store.state.authentication.status.loggingIn
    }
  },
  created () {
    this.$store.dispatch('authentication/logout')
  },
  methods: {
    handleSubmit (e) {
        this.submitted = true
        const {username, password} = this
        const {dispatch} = this.$store
        if (username && password) {
          dispatch('authentication/login', {username, password})
        }
      }
    }
}

</script>

<style scoped>
  #loginForm {
    width: 50%;
    display: inline-block;
    box-sizing: border-box;
    text-align: left;
    padding-top: 20px;
  }
  label {
    font-weight: bold;
  }
  input {
    width: 100%;
    padding: 15px;
    margin: 0 0 22px 0;
    border: none;
    background: #f1f1f1;
  }
  input:focus {
    background-color: #ddd;
    outline: none;
  }
  .loginButton {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
  }
  .loginButton:disabled {
    background-color: gray;
    cursor: not-allowed;
  }
  .loginButton:hover {
    opacity: 1;
  }
</style>
