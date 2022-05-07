import type { ReviewDTO } from "@/models/review";
import { parseData } from ".";
import http from "./http";

export const getAllReviews = () =>
  http.get<ReviewDTO[]>("/reviews").then(parseData);

export const getReviewsForHardware = (code: string) =>
  http.get<ReviewDTO[]>(`/reviews/${code}`).then(parseData);
