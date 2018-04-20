<template>
<div>
    <button class=”Search__button” @click="callRestService()">Get guests</button>

    <div>
        <b-dropdown id="ddown1" text="Dropdown Button" class="m-md-2">
            <b-dropdown-item v-for="guest in response"
                        :key="guest.name"
                        :value="guest.name">
                {{guest.name}}
            </b-dropdown-item>
        </b-dropdown>
    </div>

</div>
</template>

<script>
import {AXIOS} from '@/config/http-common'

export default {

  data () {
    return {
      response: [],
      errors: []
    }
  },

  methods: {
    callRestService () {
      AXIOS.get(`api/guests`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.response = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>
