import axios from 'axios';

const API_URL = 'http://localhost:8080/pasakumi/all';

const API_URL_Categories = 'http://localhost:8080/pasakumi/categories';
const API_URL_SORT = 'http://localhost:8080/pasakumi/sort/category'; 
const API_URL_DATE_FILTER = 'http://localhost:8080/pasakumi/filter-by-date';


class UserService {
    getAllPasakumi() {
        return axios.get(API_URL);
    }

    getCategories() {
        return axios.get(API_URL_Categories);
    }

    getPasakumiByCategory(categoryId) {
        return axios.get(`${API_URL_SORT}/${categoryId}`); 
    }

    getEventsByDate(date) {
        return axios.get(`${API_URL_DATE_FILTER}?date=${date}`);  
    }
}

export default new UserService();
