import type { ReviewDTO } from "@/models/review";
import { set } from "@vueuse/core";
import { findReviewById } from "@/services/reviews";

export const useReviewById = () => {
  const loading = ref(false);
  const review = ref<ReviewDTO>();

  const fetchReview = async (id: string) => {
    set(loading, true);
    try {
      const fetchedReview = await findReviewById(id);
      set(review, fetchedReview);
    } catch (err: any) {
      console.error("Error fetching review", err);
      set(review, null);
    } finally {
      set(loading, false);
    }
  };

  return {
    loading,
    fetchReview,
    review,
  };
};
