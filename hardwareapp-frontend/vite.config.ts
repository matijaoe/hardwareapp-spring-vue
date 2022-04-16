import { fileURLToPath, URL } from "url";

import vue from "@vitejs/plugin-vue";
import Unocss from "unocss/vite";
import AutoImport from "unplugin-auto-import/vite";
import { NaiveUiResolver } from "unplugin-vue-components/resolvers";
import Components from "unplugin-vue-components/vite";
import { defineConfig } from "vite";
import ViteFonts from "vite-plugin-fonts";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    AutoImport({
      imports: ["vue", "vue/macros", "vue-router", "pinia", "@vueuse/core"],
      dts: true,
    }),
    ViteFonts({
      google: {
        families: ["Ubuntu", "Roboto Mono"],
      },
    }),
    Components({
      resolvers: [NaiveUiResolver()],
    }),
    Unocss({}),
  ],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", import.meta.url)),
    },
  },
});
