import {
  defineConfig,
  presetUno,
  // transformerDirectives,
  // transformerVariantGroup,
} from "unocss";

export default defineConfig({
  shortcuts: [],
  presets: [presetUno()],
  theme: {
    extend: {
      colors: {
        kajgod: {
          500: "#63e2b7",
        },
      },
    },
  },
});
