import API from '../Api';
class UserService {
    getAllPasakumi() {
        return API.get('/pasakumi/all');
    }

    getCategories() {
        return API.get('/pasakumi/categories');
    }

    getPasakumiByCategory(categoryId) {
        return API.get(`/pasakumi/sort/category/${categoryId}`);
    }

    getEventsByDate(date) {
        return API.get(`/pasakumi/filter-by-date?date=${date}`);
    }
}

export default new UserService();
