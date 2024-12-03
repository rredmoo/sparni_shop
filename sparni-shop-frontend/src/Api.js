import axios from 'axios';

const API = axios.create({
    baseURL: 'http://localhost:8081',
});


API.interceptors.request.use((config) => {
    const preferredLanguage = localStorage.getItem('preferredLanguage') || 'lv';
    config.headers['Accept-Language'] = preferredLanguage;
    return config;
  });

export default API;
