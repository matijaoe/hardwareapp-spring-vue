import type { Review } from "@/models/review";
import { parseData } from ".";
import http from "./http";

export const getAllReviews = () =>
  http.get<Review[]>("/reviews").then(parseData);

export const getReviewByTitle = (title: string) =>
  http.get<Review>(`/reviews/${title}`).then(parseData);
