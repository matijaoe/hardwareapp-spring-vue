import HomeView from "@/views/HomeView.vue";
import HardwareView from "@/views/Hardware/HardwareView.vue";
import HardwareItemView from "@/views/Hardware/HardwareView.vue";

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
    path: "/details/:code",
    name: "HardwareItem",
    component: HardwareItemView,
  },
];

export default routes;
