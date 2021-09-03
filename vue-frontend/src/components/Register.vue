<template>
  <div class="container mx-auto mt-50px">
    <div class="container mt-72">
      <h1 class="text-lg font-bold">Sign Up</h1>
      <form v-on:submit="registerUser">
        <input
          v-model="username"
          type="text"
          placeholder="Username"
          class="border-2 w-72 text-center mt-5  inline-block h-8 focus:ring-indigo-500 focus:border-indigo-500 border-gray-300 rounded-md"
        />
        <div>
          <input
            v-model="password"
            type="password"
            placeholder="Password"
            class="border-2 w-72 text-center mt-5  inline-block h-8 focus:ring-indigo-500 focus:border-indigo-500 border-gray-300 rounded-md"
          />
        </div>
        <button
          class="bg-indigo-600 hover:bg-indigo-700 text-white font-bold py-2 px-4 rounded mt-3 w-40"
          type="submit"
        >
          Register
        </button>
      </form>
    </div>
  </div>
</template>

<script lang="ts">
import axios from "axios";
import { defineComponent, ref } from "vue";

export default defineComponent({
  name: "register",
  setup() {
    //  this is like a js variable which vue knows of. this is for data
    const username = ref();
    const password = ref();

    const client = axios.create({
      baseURL: "http://localhost:8081/api",
      timeout: 1000,
    });

    function registerUser(e: Event) {
      e.preventDefault();

      const data = {
        username: username.value,
        password: password.value,
      };

      console.log(data);

      client
        .post("/v1/user/register", data)
        .then((response) => {
          console.log(response.data);
        })
        .catch((err) => {
          console.log(err.response.data);
        });
    }

    return {
      username,
      password,
      registerUser,
    };
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
