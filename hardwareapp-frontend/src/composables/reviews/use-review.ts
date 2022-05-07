import type { ReviewDTO } from "@/models/review";
import { set } from "@vueuse/core";
import { getReviewsForHardware } from "@/services/reviews";

export const useHardwareReviews = () => {
  const loading = ref(false);
  const reviews = ref<ReviewDTO[]>([]);

  const fetchReviews = async (code: string) => {
    set(loading, true);
    try {
      const fetchedReviews = await getReviewsForHardware(code);
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
    fetchReviews,
    reviews,
  };
};
