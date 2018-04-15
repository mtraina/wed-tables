<template>
<div>
    <button class=”Search__button” @click="callRestService()">Get guests</button>
    <h3>{{ response }}</h3>
</div>
</template>

<script>
import axios from 'axios'

export default {

  data () {
    return {
      response: [],
      errors: []
    }
  },

  callRestService () {
    axios.get(`api/guests`)
      .then(response => {
        // JSON responses are automatically parsed.
        this.response = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })
  }
}
</script>
