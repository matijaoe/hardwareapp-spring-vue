import HomeView from "@/views/HomeView.vue";
import HardwareView from "@/views/Hardware/HardwareView.vue";
import HardwareItemView from "@/views/Hardware/HardwareItemView.vue";
import ReviewPage from "@/views/Review/ReviewPage.vue";
import ReviewsPage from "@/views/Review/ReviewsPage.vue";

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
    component: ReviewsPage,
  },
  {
    path: "/reviews/:id",
    name: "Review",
    component: ReviewPage,
  },
];

export default routes;
