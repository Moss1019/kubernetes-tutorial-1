import axios from './axios';
import { SERVER_END_POINT } from './axios';

export function createItem(item: any, onSuccess: (data: any) => void, onError: (err: any) => void) {
	const url = `${SERVER_END_POINT}/items`;
	axios.post(url, item)
		.then(result => {
			onSuccess(result.data);
		})
		.catch(err => {
			onError(err);
		});
};

export function deleteItem(itemId: string, onSuccess: (data: any) => void, onError: (err: any) => void) {
	const url = `${SERVER_END_POINT}/items/${itemId}`;
	axios.delete(url)
		.then(result => {
			onSuccess(result.data);
		})
		.catch(err => {
			onError(err);
		});
};

export function getItemById(itemId: string, onSuccess: (data: any) => void, onError: (err: any) => void) {
	const url = `${SERVER_END_POINT}/items/${itemId}`;
	axios.get(url)
		.then(result => {
			onSuccess(result.data);
		})
		.catch(err => {
			onError(err);
		});
};

export function getAllItems(onSuccess: (data: any) => void, onError: (err: any) => void) {
	const url = `${SERVER_END_POINT}/items`;
  axios.get(url)
		.then(result => {
			onSuccess(result.data);
		})
		.catch(err => {
			onError(err);
		});
};

export function getItemByTitle(title: string, onSuccess: (data: any) => void, onError: (err: any) => any) {
	const url = `${SERVER_END_POINT}/items/byTitle/${title}`;
	axios.get(url)
		.then(result => {
			onSuccess(result.data);
		})
		.catch(err => {
			onError(err);
		});
};

export function updateItem(item: any, onSuccess: (data: any) => void, onError: (err: any) => void) {
	const url = `${SERVER_END_POINT}/items`;
	axios.put(url, item)
		.then(result => {
			onSuccess(result.data);
		})
		.catch(err => {
			onError(err);
		});
};
