import HomeView from "@/views/HomeView.vue";
import HardwareView from "@/views/Hardware/HardwareView.vue";
import HardwareItemView from "@/views/Hardware/HardwareItemView.vue";
import ReviewsView from "@/views/Reviews/ReviewsView.vue";
import ReviewView from "@/views/Reviews/ReviewView.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/hardware",
    name: "Hardware",
    component: HardwareView,
  },
  {
    path: "/hardware/details/:code",
    name: "HardwareItem",
    component: HardwareItemView,
  },
  {
    path: "/reviews",
    name: "Reviews",
    component: ReviewsView,
  },
  {
    path: "/reviews/:title",
    name: "ReviewItem",
    component: ReviewView,
  },
];

export default routes;
