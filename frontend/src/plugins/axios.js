//import Vue from 'vue';
import axios from 'axios';

const Http = axios.create({
    baseURL: 'http://localhost:8080/value=/api/',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
    }
})

export default Http