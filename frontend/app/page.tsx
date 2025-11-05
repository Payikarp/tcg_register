import Image from "next/image";
import "@/app/css/homeStyles.css"

export default function Home() {
  return (
    <html>
      <body>
        <div id="container">
            <div id="titleDiv">
          <p className="titleClass">TCG Register</p>
          <Image id="enterButton"
          src="/images/enterButton.png"
          width={100}
          height={100}
          alt="Enter">
          </Image>
          </div>
          <div id="backgroundDiv">
            <img src="https://sm.ign.com/t/ign_latam/screenshot/default/chainsaw-man-the-movie-reze-arc_r15w.1280.jpg"></img>
          </div>
        </div>
    </body>
    </html>
  );
}
