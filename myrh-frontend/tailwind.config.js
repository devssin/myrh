/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
    "./node_modules/flowbite/**/*.js"

  ],
  theme: {
    colors: {
      "primary": "#3a4b9a",
      "secondary": "#eedbe1"
    },
    extend: {},
  },
  plugins: [
    require('flowbite/plugin')
  ],
}