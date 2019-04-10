<template>
  <div>
    <div class="hello">
      <h1>{{ msg }}</h1>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'App',
  data () {
    return {
      msg: null,
    }
  },
  mounted () {
    axios.get('http://localhost:8080/api/hello').then(response => (this.msg = response.data));
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1 {
    font-weight: bolder;
    font-size: 55px;
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    color: white;
    margin: 0;
    padding-top: 250px;
  }
  .hello {
    height: 500px;
    background-image: url("../assets/sunset.jpg");
    background-size: cover;
    background-size: 100%;
    background-position: center;
  }
</style>
