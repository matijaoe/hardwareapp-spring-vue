import type { ReviewDTO } from "@/models/review";
import { set } from "@vueuse/core";
import { searchReviewsByTitle } from "@/services/reviews";

export const useHardwareReviewsByTitle = () => {
  const loading = ref(false);
  const reviews = ref<ReviewDTO[]>([]);

  const fetchReviewsByTitle = async (title: string) => {
    set(loading, true);
    try {
      console.log("title :>> ", title);
      const fetchedReviews = await searchReviewsByTitle(title);
      set(reviews, fetchedReviews ?? []);
    } catch (err: any) {
      console.error("Error fetching reviews", err);
      set(reviews, null);
    } finally {
      set(loading, false);
    }
  };

  return {
    loading,
    fetchReviewsByTitle,
    reviews,
  };
};
