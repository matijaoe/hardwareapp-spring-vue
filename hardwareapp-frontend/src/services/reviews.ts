import type { ReviewDTO } from "@/models/review";
import { parseData } from ".";
import http from "./http";

export const getAllReviews = () =>
  http.get<ReviewDTO[]>("/reviews").then(parseData);

export const searchReviewsByTitle = (query: string) =>
  http.get<ReviewDTO[]>(`/reviews/search?query=${query}`, {}).then(parseData);

export const findReviewById = (id: string) =>
  http.get<ReviewDTO>(`/reviews/details/${id}`).then(parseData);

export const getReviewsForHardware = (code: string) =>
  http.get<ReviewDTO[]>(`/reviews/${code}`).then(parseData);
