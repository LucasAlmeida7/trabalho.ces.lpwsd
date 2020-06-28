<template>
  <v-app>
    <router-view name="header"></router-view>
    <main>
      <v-content>
          <router-view />
      </v-content>
    </main>
  </v-app>
</template>

<style>



#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>


