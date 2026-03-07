package com.example.marketplace.controller;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.ProductRepository;
import com.example.marketplace.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public TestController(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public String populateDatabase() {

        if (productRepository.count() > 0) {
            return "redirect:/";
        }

        // 1) Dark Chocolate
        productRepository.save(new Product(
                "Dark Chocolate",
                "Classic dark chocolate cake",
                """
                <h2>Midnight Velvet: The Dark Chocolate Indulgence Box</h2>

                <p>
                  Experience the ultimate celebration of chocolate in its richest, most luxurious form.
                  Our <strong>Midnight Velvet Dark Chocolate Dessert Box</strong> is crafted for those who believe
                  there is no such thing as too much chocolate. 

                <h3>A Symphony of Chocolate Layers</h3>

                <ul>
                  <li><strong>The Flourless Chocolate Sponge:</strong> A dense, fudgy base made with premium dark chocolate, providing a rich and moist foundation for the dessert.</li>
                  <li><strong>The Dark Chocolate Ganache Mousse:</strong> A silky, whipped ganache made from 70% cocoa chocolate, offering a smooth, cloud-like texture that melts effortlessly.</li>
                  <li><strong>Chocolate Shortbread Crumble:</strong> A layer of delicate chocolate biscuit crumbs that introduces a satisfying crunch to contrast the soft mousse.</li>
                  <li><strong>The Bittersweet Chocolate Drizzle:</strong> A glossy finish of melted dark chocolate topped with fine chocolate shavings for an elegant final touch.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Core Flavors</td><td>Intense Dark Chocolate, Cocoa, Subtle Caramel Notes</td></tr>
                    <tr><td>Presentation</td><td>Elegant 10cm x 10cm clear-view dessert container</td></tr>
                    <tr><td>Sweetness Level</td><td>Balanced / Semi-Sweet (3/5)</td></tr>
                    <tr><td>Dietary Info</td><td>Contains dairy and gluten; best kept refrigerated.</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The Midnight Velvet Box is the gold standard for chocolate lovers —
                  dark, rich, and irresistibly smooth with every bite.”
                </blockquote>

                <p>
                  Ready to surrender to the dark side? Add the
                  <strong>Midnight Velvet Dark Chocolate Box</strong> to your cart and
                  experience chocolate the way it was meant to be enjoyed.
                </p>
                """,
                10.99,
                50,
                "/product_img/DarkChocolate_Main.png",
                true
        ));

        // 2) Nutella / Ferrero
        productRepository.save(new Product(
                "Nutella",
                "Hazelnut chocolate indulgence",
                """
                <h2>Hazelnut Heaven: The Ultimate Nutella Ferrero Dessert Box</h2>

                <p>
                  Indulge in the world’s most beloved chocolate-hazelnut spread with our
                  <strong>Hazelnut Heaven Nutella Dessert Box</strong>. Inspired by the iconic
                  Ferrero Rocher experience, this dessert transforms the irresistible pairing
                  of chocolate and hazelnut into a luxurious, multi-layered masterpiece.
                </p>

                <h3>The Architecture of Decadence</h3>

                <ul>
                  <li><strong>The Midnight Fudge Base:</strong> A dense, moist chocolate mud cake that forms a rich, fudgy foundation for the lighter layers above.</li>
                  <li><strong>The Nutella Velvet Mousse:</strong> A whipped mousse made with cream cheese and authentic Nutella, creating a smooth, airy layer filled with roasted hazelnut flavor.</li>
                  <li><strong>The Ganache Mantle:</strong> A glossy coating of dark chocolate ganache that adds a luxurious bittersweet finish.</li>
                  <li><strong>The Roasted Crown:</strong> A topping of crushed toasted hazelnuts and a delicate drizzle of white chocolate for the perfect crunchy contrast.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Primary Flavors</td><td>Roasted Hazelnut, Milk Chocolate, Dark Cocoa</td></tr>
                    <tr><td>Core Ingredients</td><td>Authentic Nutella, Toasted Hazelnuts, Premium Cocoa</td></tr>
                    <tr><td>Sweetness Level</td><td>Rich &amp; Indulgent (4.5/5)</td></tr>
                    <tr><td>Serving Size</td><td>500ml Box (Perfect for sharing or a generous solo treat)</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “If happiness had a flavor, it would be this box.
                  It’s like enjoying the inside of a Ferrero Rocher with a spoon—only better.”
                </blockquote>

                <p>
                  Ready to surrender to the hazelnut haze? Add the
                  <strong>Hazelnut Heaven Nutella Dessert Box</strong> to your cart today and
                  experience the ultimate chocolate-hazelnut indulgence.
                </p>
                """,
                11.49,
                40,
                "/product_img/Nutella_Main.png",
                true
        ));

        // 3) Tiramisu
        productRepository.save(new Product(
                "Tiramisu",
                "Coffee-infused Italian classic",
                """
                <h2>Midnight Espresso: The Authentic Italian Tiramisu Box</h2>

                <p>
                  Experience the timeless elegance of Italy with our
                  <strong>Midnight Espresso Tiramisu Dessert Box</strong>. Inspired by the
                  classic Venetian dessert, this creation celebrates the perfect harmony of
                  bold espresso, silky mascarpone cream, and delicate cocoa.
                </p>

                <h3>The Architecture of an Italian Classic</h3>

                <ul>
                  <li><strong>The Savoiardi Foundation:</strong> Authentic Italian ladyfingers soaked in freshly brewed dark roast espresso with a touch of Madagascar vanilla.</li>
                  <li><strong>The Mascarpone Cloud:</strong> A rich yet airy mascarpone cream made with imported Italian cheese, whipped with egg yolks and fresh dairy cream.</li>
                  <li><strong>The Cocoa Dusting:</strong> A generous layer of Dutch-processed cocoa powder that adds a refined bittersweet contrast to the creamy filling.</li>
                  <li><strong>The Secret Interior:</strong> Hidden fragments of dark chocolate shavings tucked between the layers for a subtle crunch and deeper chocolate flavor.</li>
                </ul>

                <h3>Why You’ll Fall in Love</h3>

                <ul>
                  <li><strong>Real Espresso Flavor:</strong> Brewed with premium dark roast espresso to deliver a rich and aromatic coffee experience.</li>
                  <li><strong>Authentic Italian Texture:</strong> The ladyfingers are soaked to achieve a moist, cake-like consistency without becoming soggy.</li>
                  <li><strong>Balanced Sweetness:</strong> The mascarpone cream and dark cocoa create a refined dessert that is rich yet never overly sweet.</li>
                  <li><strong>Portable Luxury:</strong> Served in our clear-view dessert box, perfect for office treats, picnics, or a relaxing evening indulgence.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Primary Flavors</td><td>Bold Espresso, Creamy Mascarpone, Dark Cocoa</td></tr>
                    <tr><td>Core Ingredients</td><td>Italian Ladyfingers, Real Espresso, Mascarpone Cheese</td></tr>
                    <tr><td>Sweetness Level</td><td>Refined / Bittersweet Balance (2.5/5)</td></tr>
                    <tr><td>Serving Suggestion</td><td>Best served chilled; pairs perfectly with hot espresso or sweet Vin Santo</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The Midnight Espresso is the gold standard of tiramisu—light, airy,
                  and filled with the deep coffee flavor every tiramisu lover dreams of.”
                </blockquote>

                <p>
                  Ready for the ultimate pick-me-up? Add the
                  <strong>Midnight Espresso Tiramisu Dessert Box</strong> to your cart today
                  and bring the taste of Italy straight to your table.
                </p>
                """,
                12.49,
                35,
                "/product_img/Tiramisu_Main.png",
                true
        ));

        // 4) Matcha
        productRepository.save(new Product(
                "Matcha",
                "Earthy Japanese green tea",
                """
                <h2>Zen Garden: The Ceremonial Matcha Tiramisu Box</h2>

                <p>
                  Find your moment of calm with our <strong>Zen Garden Matcha Dessert Box</strong>.
                  Designed for true tea lovers, this dessert highlights the refined complexity
                  of authentic Uji matcha.
                </p>
                
                <h3>The Architecture of Tranquility</h3>
                <ul>
                  <li><strong>The Matcha-Soaked Ladyfingers:</strong> Light sponge biscuits soaked in a concentrated ceremonial-grade matcha infusion, forming a moist and earthy base.</li>
                  <li><strong>The Emerald Mascarpone:</strong> A silky mascarpone cream blended with premium matcha powder, creating a velvety layer that balances tanginess with subtle floral notes.</li>
                  <li><strong>The Mossy Crown:</strong> A generous dusting of vibrant matcha powder across the surface, reminiscent of the calm beauty of a Japanese moss garden.</li>
                  <li><strong>The Centerpiece:</strong> Finished with handmade matcha chocolate truffles that add a dense, fudgy contrast to the airy cream layers.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Main Flavors</td><td>Umami Matcha, Creamy Mascarpone, Subtle Vanilla</td></tr>
                    <tr><td>Texture</td><td>Melt-in-your-mouth Cream, Moist Sponge, Dense Truffle</td></tr>
                    <tr><td>Sweetness Level</td><td>Low to Moderate (2/5)</td></tr>
                    <tr><td>Best Paired With</td><td>A warm cup of Sencha or a cold-brew Oolong tea</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “This isn't just a cake; it’s a meditative experience.
                  The depth of the matcha is unparalleled and the texture is as light as a summer breeze.”
                </blockquote>

                <p>
                  Find your zen in every spoonful. Order your
                  <strong>Zen Garden Matcha Dessert Box</strong> today and bring the calm
                  elegance of a Japanese teahouse into your home.
                </p>
                """,
                11.99,
                30,
                "/product_img/Matcha_Main.png",
                true
        ));

        // 5) Red Velvet
        productRepository.save(new Product(
                "Red Velvet",
                "Smooth cocoa with cream cheese",
                """
                <h2>Crimson Romance: The Signature Red Velvet Dessert Box</h2>

                <p>
                  Indulge in the timeless elegance of our
                  <strong>Crimson Romance Red Velvet Dessert Box</strong>. Inspired by the
                  classic Red Velvet cake, this dessert transforms the beloved favorite into
                  a modern, spoonable creation layered with rich cocoa sponge and silky
                  cream cheese frosting.
                </p>

                <h3>A Masterpiece of Layering</h3>

                <ul>
                  <li><strong>The Cocoa-Infused Foundation:</strong> A soft, moist red velvet sponge cake with subtle cocoa notes and its iconic crimson color.</li>
                  <li><strong>The Tangy Cloud:</strong> Generous layers of whipped cream cheese frosting, light and airy with the perfect tangy sweetness.</li>
                  <li><strong>The Velvet Dusting:</strong> A delicate topping of fine red velvet cake crumbs that melt gently into the cream.</li>
                  <li><strong>The Artisanal Finish:</strong> Elegant piped cream layers visible through the clear-view dessert box, highlighting the striking red and white contrast.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Primary Flavors</td><td>Subtle Cocoa, Tangy Cream Cheese, Buttermilk</td></tr>
                    <tr><td>Texture</td><td>Ultra-Moist, Velvety, and Airy</td></tr>
                    <tr><td>Sweetness Level</td><td>Balanced and Refined (3/5)</td></tr>
                    <tr><td>Serving Size</td><td>500ml Box (Ideal for sharing or a decadent personal treat)</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The Crimson Romance is a love letter to dessert lovers.
                  Light enough for an afternoon treat yet indulgent enough to finish a
                  memorable dinner.”
                </blockquote>

                <p>
                  Ready to experience the velvet revolution? Add the
                  <strong>Crimson Romance Red Velvet Dessert Box</strong> to your cart today
                  and enjoy the elegance of Red Velvet in every spoonful.
                </p>
                """,
                11.99,
                40,
                "/product_img/RedVelvet_Main.png",
                true
        ));

        // 6) Nastar
        productRepository.save(new Product(
                "Nastar",
                "Indonesian pineapple delight",
                """
                <h2>Golden Pineapple Heritage: The Signature Nastar Dessert Box</h2>

                <p>
                  Celebrate the warmth of tradition with our
                  <strong>Golden Pineapple Heritage Nastar Dessert Box</strong>.
                  Inspired by the iconic Indonesian pineapple tart, this dessert reimagines
                  the beloved festive treat as a luxurious, spoonable experience.
                </p>

                <h3>A Masterclass in Buttery Perfection</h3>

                <ul>
                  <li><strong>The Melt-Away Base:</strong> A crumbly golden butter cake that recreates the soft, melt-in-your-mouth texture of traditional Nastar pastry.</li>
                  <li><strong>The Silky Custard Heart:</strong> A light vanilla-infused cream layer made with premium Madagascar vanilla, offering a smooth contrast to the rich cake base.</li>
                  <li><strong>The Artisanal Jam Crown:</strong> A generous layer of house-made pineapple jam slowly cooked to develop a deep amber color and balanced sweet–tart flavor.</li>
                  <li><strong>The Gourmet Garnish:</strong> Finished with a delicate drizzle of white chocolate ganache and buttery cookie crumbs for added crunch and elegance.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Flavor Profile</td><td>Tangy Pineapple, Rich Butter, Sweet Vanilla</td></tr>
                    <tr><td>Core Ingredients</td><td>House-made Pineapple Compote, Premium Butter, Fresh Dairy Cream</td></tr>
                    <tr><td>Sweetness Level</td><td>Comfortably Sweet (3.5/5)</td></tr>
                    <tr><td>Serving Suggestion</td><td>Pairs beautifully with hot Earl Grey or traditional jasmine tea</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The Golden Pineapple Heritage box is like capturing sunshine in a jar.
                  It’s everything you love about traditional Nastar, elevated with layers
                  of creamy luxury.”
                </blockquote>

                <p>
                  Ready to indulge in a golden tradition? Add the
                  <strong>Nastar Dessert Box</strong> to your cart today and discover the
                  perfect harmony of heritage and modern dessert craft.
                </p>
                """,
                10.49,
                30,
                "/product_img/Nastar_Main.png",
                true
        ));

        // 7) Klepon
        productRepository.save(new Product(
                "Klepon",
                "Palm sugar & coconut",
                """
                <h2>Emerald Bliss: The Klepon Fusion Dessert Box</h2>

                <p>
                  Experience the soul of Indonesian tradition reimagined in a contemporary masterpiece.
                  Our <strong>Emerald Bliss Klepon Dessert Box</strong> takes the beloved flavors of the classic <em>jajan pasar</em>
                  and transforms them into a sophisticated, multi-layered cake experience.
                </p>

                <h3>A Symphony of Traditional Flavors</h3>

                <ul>
                  <li><strong>The Pandan Sponge:</strong> A vibrant, airy green sponge cake infused with the natural essence of fresh pandan leaves, providing a soft and aromatic base.</li>
                  <li><strong>The Coconut Cream Mousse:</strong> A light-as-air coconut mousse that mimics the classic grated coconut coating, offering a silky contrast to the cake layers.</li>
                  <li><strong>Hidden Treasures:</strong> Embedded within the cream are chewy, pandan-infused pearls that recreate the playful, elastic bite of traditional klepon rice cakes.</li>
                  <li><strong>The Palm Sugar Glaze:</strong> A thick, glossy swirl of artisanal <strong>Gula Melaka</strong> (palm sugar) that coats the top, providing a deep, smoky sweetness that ties every layer together.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Core Flavors</td><td>Pandan, Fresh Coconut, Liquid Palm Sugar</td></tr>
                    <tr><td>Presentation</td><td>Elegant 10cm x 10cm clear-view safety container</td></tr>
                    <tr><td>Sweetness Level</td><td>Classic Sweet (4/5)</td></tr>
                    <tr><td>Dietary Info</td><td>Contains dairy and gluten; best consumed fresh.</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The Emerald Bliss is like a warm hug from your childhood, served in a modern, velvety dream.
                  It’s the heritage dessert you didn't know could get this good.”
                </blockquote>

                <p>
                  Rediscover a classic in a whole new light. Order your <strong>Emerald Bliss Klepon Box</strong> now and bring a taste of Indonesian heritage to your table.
                </p>
                """,
                10.99,
                25,
                "/product_img/Klepon_Main.png",
                true
        ));

        // 8) Mango Float
        productRepository.save(new Product(
                "Mango Float",
                "Filipino-style mango dessert",
                """
                <h2>Sun-Kissed Golden Mango Float: A Tropical Escape in a Box</h2>

                <p>
                  Transport your taste buds to a tropical paradise with our
                  <strong>Golden Mango Float Dessert Box</strong>. This refreshing dessert captures
                  the vibrant, sun-drenched flavours of perfectly ripe mangoes layered with
                  velvety cream and buttery crackers.
                </p>

                <h3>Layers of Pure Sunshine</h3>

                <ul>
                  <li><strong>The Buttery Crust:</strong> A crumbly golden base made from crushed premium honey crackers, adding a delicate salty-sweet crunch that anchors the dessert.</li>
                  <li><strong>The Velvet Cloud:</strong> Layers of whipped sweetened cream and condensed milk, chilled to a semi-frozen consistency that melts like rich gelato.</li>
                  <li><strong>The Mango Heart:</strong> Generous slices of hand-picked, tree-ripened mangoes layered throughout, ensuring a burst of bright tropical fruit in every bite.</li>
                  <li><strong>The Crown Jewel:</strong> Fresh mango cubes and slices beautifully arranged on top, finished with a light dusting of graham cracker “sand” for the signature mango float look.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Main Flavors</td><td>Ripe Tropical Mango, Sweet Cream, Honey Graham</td></tr>
                    <tr><td>Texture</td><td>Creamy, Soft-Set, and Refreshing</td></tr>
                    <tr><td>Sweetness Level</td><td>Naturally Sweet &amp; Refreshing (3.5/5)</td></tr>
                    <tr><td>Serving Suggestion</td><td>Best served straight from the fridge or slightly frozen for an ice-cream cake feel</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “One bite of this mango float and you're instantly on island time.
                  It’s light, bright, and dangerously addictive.”
                </blockquote>

                <p>
                  Bring home the taste of summer. Our
                  <strong>Golden Mango Float Dessert Boxes</strong> are made in small batches to
                  ensure fruit freshness—grab yours before they’re gone!
                </p>
                """,
                11.49,
                35,
                "/product_img/MangoFloat_Main.png",
                true
        ));

        // 9) Ube
        productRepository.save(new Product(
                "Ube",
                "Purple yam sweetness",
                """
                <h2>Violet Velvet: The Signature Ube Coconut Dessert Box</h2>

                <p>
                  Experience the vibrant flavors of the Philippines with our
                  <strong>Violet Velvet Ube Coconut Dessert Box</strong>. Inspired by the beloved
                  purple yam dessert, this creation transforms traditional Ube Halaya into a
                  modern, layered treat that is both visually stunning and irresistibly creamy.
                </p>

                <h3>A Masterpiece of Island Flavors</h3>

                <ul>
                  <li><strong>The Ube Chiffon Foundation:</strong> A soft, airy sponge cake infused with real ube, offering a naturally vibrant violet color and delicate earthy flavor.</li>
                  <li><strong>The Halaya Heart:</strong> A smooth mousse made from house-cooked Ube Halaya, delivering a rich, jam-like texture that melts into creamy layers.</li>
                  <li><strong>The Coconut Cloud:</strong> A topping of lightly whipped coconut cream that adds a refreshing tropical brightness.</li>
                  <li><strong>The Snowy Finish:</strong> Freshly grated young coconut flakes scattered across the top, bringing gentle saltiness and a subtle crunchy texture.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Main Flavors</td><td>Earthy Ube (Purple Yam), Creamy Coconut, Natural Vanilla</td></tr>
                    <tr><td>Texture</td><td>Silky, Moist, and Lightly Flaky</td></tr>
                    <tr><td>Sweetness Level</td><td>Subtle &amp; Sophisticated (2.5/5)</td></tr>
                    <tr><td>Serving Size</td><td>500ml Box (Perfect for sharing or a luxurious solo treat)</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The Violet Velvet is like a tropical vacation in a box — a beautiful
                  marriage of traditional Filipino flavors and modern dessert artistry.”
                </blockquote>

                <p>
                  Ready to experience the purple delight? Add the
                  <strong>Violet Velvet Ube Coconut Dessert Box</strong> to your cart today
                  and enjoy the gold standard of tropical desserts.
                </p>
                """,
                11.99,
                30,
                "/product_img/Ube_Main.png",
                true
        ));

        // 10) Oolong Tea
        productRepository.save(new Product(
                "Oolong Tea",
                "Fragrant tea-infused cake",
                """
                <h2>Imperial Steep: The Signature Oolong Tea Dessert Box</h2>

                <p>
                  Discover the quiet elegance of fine tea craftsmanship with our
                  <strong>Imperial Steep Oolong Tea Dessert Box</strong>. Designed for the
                  refined palate, this dessert captures the floral complexity and toasted
                  depth of premium high-mountain Oolong tea.
                </p>

                <h3>The Architecture of Flavor</h3>

                <ul>
                  <li><strong>The Toasted Malt Base:</strong> A buttery crushed biscuit crust infused with roasted tea leaves, providing a nutty, malted crunch that anchors the dessert.</li>
                  <li><strong>The Oolong Infusion:</strong> A velvety mousse created by slow-steeping premium Oolong leaves in fresh cream, extracting delicate floral and honey-like notes.</li>
                  <li><strong>The Caramelized Glaze:</strong> A smooth tea-infused glaze with a warm amber tone that mirrors the beauty of a perfectly brewed cup.</li>
                  <li><strong>The Finishing Garnish:</strong> A sprinkle of toasted tea leaf fragments and a light drizzle of condensed milk, adding both aroma and creamy sweetness.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Flavor Profile</td><td>Floral, Toasted Nut, Subtle Honey, Roasted Malt</td></tr>
                    <tr><td>Core Ingredients</td><td>Premium Whole-Leaf Oolong, Fresh Cream, Malted Biscuits</td></tr>
                    <tr><td>Sweetness Level</td><td>Refined / Low-Moderate (2/5)</td></tr>
                    <tr><td>Best Enjoyed</td><td>Chilled, alongside a warm cup of light tea or sparkling water</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “This is the ultimate dessert for those who find beauty in the subtle.
                  It captures the essence of a peaceful afternoon tea in every bite.”
                </blockquote>

                <p>
                  Elevate your dessert hour. Order your
                  <strong>Imperial Steep Oolong Tea Dessert Box</strong> today and
                  experience the perfect harmony of tea and cream.
                </p>
                """,
                11.49,
                25,
                "/product_img/OolongTea_Main.png",
                true
        ));

        // 11) Lotus Biscoff
        productRepository.save(new Product(
                "Lotus Biscoff",
                "Caramelised biscuit favourite",
                """
                <h2>Caramelized Harmony: The Signature Lotus Biscoff Dessert Box</h2>

                <p>
                  Indulge in the flavor that has taken the world by storm with our
                  <strong>Caramelized Harmony Lotus Biscoff Dessert Box</strong>. This decadent
                  dessert celebrates the unmistakable spiced caramel sweetness of the iconic
                  Lotus Biscoff biscuit, transformed into a luxurious multi-layered treat.
                </p>

                <h3>A Multi-Layered Cookie Masterpiece</h3>

                <ul>
                  <li><strong>The Speculoos Base:</strong> A buttery crust made from crushed authentic Lotus Biscoff biscuits, forming a crunchy, spiced foundation.</li>
                  <li><strong>The Biscoff Infused Cloud:</strong> A silky mousse made with cream cheese and white chocolate, folded with ribbons of smooth Biscoff cookie butter.</li>
                  <li><strong>The Liquid Gold Mantle:</strong> A glossy layer of melted Biscoff cookie butter glaze that intensifies the dessert’s caramelized spice notes.</li>
                  <li><strong>The Final Crunch:</strong> Finished with whole Lotus Biscoff biscuits and golden cookie crumbs for a satisfying crunch in every bite.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Primary Flavors</td><td>Caramel, Cinnamon, Toasted Ginger, Brown Sugar</td></tr>
                    <tr><td>Core Ingredients</td><td>Authentic Lotus Biscoff Biscuits &amp; Spread, Premium Cream</td></tr>
                    <tr><td>Sweetness Level</td><td>Indulgently Sweet (4.5/5)</td></tr>
                    <tr><td>Serving Suggestion</td><td>Enjoy chilled. Pairs beautifully with unsweetened coffee or tea</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “If you’re a fan of cookie butter, this isn't just a dessert—it’s a revelation.
                  It transforms the iconic biscuit into a luxurious cake experience.”
                </blockquote>

                <p>
                  Don’t just have a biscuit — enjoy the whole experience.
                  Order your <strong>Caramelized Harmony Biscoff Dessert Box</strong> today and
                  discover the ultimate cookie-butter indulgence.
                </p>
                """,
                12.49,
                40,
                "/product_img/LotusBiscoff_Main.png",
                true
        ));

        // 12) Oreo
        productRepository.save(new Product(
                "Oreo",
                "Cookies & cream classic",
                """
                <h2>Midnight Cookies &amp; Cream: The Ultimate Oreo Dream Box</h2>

                <p>
                  Experience the perfect harmony of crunch and cream with our
                  <strong>Midnight Cookies &amp; Cream Oreo Dessert Box</strong>. Inspired by
                  the world’s most iconic sandwich cookie, this dessert transforms classic
                  cookies and cream into a luxurious, multi-layered indulgence.
                </p>


                <h3>Layers of Pure Obsession</h3>

                <ul>
                  <li><strong>The Cocoa Foundation:</strong> A dense dark cocoa cake base that provides a moist, fudgy anchor for the lighter layers above.</li>
                  <li><strong>The Speckled Velvet Heart:</strong> A creamy vanilla mousse folded with crushed Oreo cookies to create the signature cookies-and-cream texture.</li>
                  <li><strong>The Ganache Seal:</strong> A smooth bittersweet chocolate glaze that bridges the creamy center with the crunchy topping.</li>
                  <li><strong>The Cookie Crown:</strong> A rich layer of Oreo cookie crumbs topped with whole Oreo biscuits for the perfect crunchy finish.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Primary Flavors</td><td>Dark Cocoa, Sweet Vanilla Cream, Classic Oreo</td></tr>
                    <tr><td>Presentation</td><td>Signature 500ml clear-view dessert box</td></tr>
                    <tr><td>Sweetness Level</td><td>Comfortably Indulgent (4/5)</td></tr>
                    <tr><td>Best Served</td><td>Chilled directly from the refrigerator</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “If you grew up twisting and licking Oreos, this is the grown-up luxury
                  version you’ve been waiting for — childhood nostalgia in a sophisticated,
                  creamy dessert box.”
                </blockquote>

                <p>
                  Ready to dive into the dark side of delicious? Add the
                  <strong>Midnight Cookies &amp; Cream Oreo Box</strong> to your cart today
                  and experience the ultimate cookies-and-cream indulgence.
                </p>
                """,
                10.99,
                45,
                "/product_img/Oreo_Main.png",
                true
        ));

        // 13) Carrot Cake
        productRepository.save(new Product(
                "Carrot Cake",
                "Spiced & comforting",
                """
                <h2>Golden Harvest: The Ultimate Spiced Carrot Dessert Box</h2>

                <p>
                  Discover the perfect balance of rustic comfort and modern luxury with our
                  <strong>Golden Harvest Carrot Dessert Box</strong>. Inspired by the beloved
                  classic carrot cake, this dessert transforms familiar flavors into a rich,
                  multi-layered experience filled with warmth, crunch, and velvety creaminess.
                </p>

                <h3>The Anatomy of a Classic Reimagined</h3>

                <ul>
                  <li><strong>The Spiced Root Foundation:</strong> A dense, incredibly moist sponge made with freshly grated organic carrots, toasted walnuts, and a warm blend of cinnamon, nutmeg, and ginger.</li>
                  <li><strong>The Silky Cloud:</strong> A generous layer of velvety cream cheese frosting, whipped until light and airy to create a tangy, smooth contrast to the rich spiced cake.</li>
                  <li><strong>The Artisanal Topping:</strong> A finishing crown of hand-crushed toasted walnuts, a drizzle of golden salted caramel, and delicate citrus zest for a bright aromatic lift.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Primary Flavors</td><td>Warm Cinnamon, Toasted Walnut, Tangy Cream Cheese</td></tr>
                    <tr><td>Texture</td><td>Moist, Nutty, and Velvety</td></tr>
                    <tr><td>Sweetness Level</td><td>Perfectly Balanced (3/5)</td></tr>
                    <tr><td>Storage</td><td>Best kept chilled; allow to sit at room temperature for 10 minutes before serving for maximum fluffiness</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “This is the carrot cake for people who take their desserts seriously.
                  It’s earthy, cozy, and luxuriously creamy all at once.”
                </blockquote>

                <p>
                  Ready to taste the harvest? Add the
                  <strong>Golden Harvest Carrot Dessert Box</strong> to your cart today and
                  experience the gold standard of spiced desserts.
                </p>
                """,
                11.49,
                30,
                "/product_img/CarrotCake_Main.png",
                true
        ));

        // 14) Strawberry Shortcake
        productRepository.save(new Product(
                "Strawberry Shortcake",
                "Light and fruity",
                """
                <h2>Sweet Serenity: The Signature Strawberry Shortcake Dessert Box</h2>

                <p>
                  Escape into a world of light, airy indulgence with our
                  <strong>Sweet Serenity Strawberry Shortcake Dessert Box</strong>. Inspired by
                  the beloved summer classic, this dessert captures the natural sweetness of
                  sun-ripened strawberries and the softness of freshly whipped cream in a
                  beautifully layered creation.
                </p>
                
                <h3>A Masterpiece of Botanical Freshness</h3>

                <p>
                  Each layer is thoughtfully crafted to celebrate the natural beauty and
                  flavor of seasonal strawberries:
                </p>

                <ul>
                  <li><strong>The Chiffon Foundation:</strong> A soft strawberry chiffon sponge that provides an ultra-light texture with a gentle natural berry aroma.</li>
                  <li><strong>The Berry Infusion:</strong> Layers of fresh sliced strawberries tucked throughout the cake, delivering bursts of juicy sweetness and refreshing acidity.</li>
                  <li><strong>The Chantilly Cloud:</strong> A generous layer of Madagascar vanilla Chantilly cream, whipped to soft peaks for a smooth, melt-in-your-mouth finish.</li>
                  <li><strong>The Crown:</strong> Topped with hand-selected strawberry halves, elegant cream rosettes, and a light sprinkle of graham cracker crumbs for subtle crunch.</li>
                </ul>

                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Primary Flavors</td><td>Fresh Strawberry, Madagascar Vanilla, Sweet Dairy</td></tr>
                    <tr><td>Texture</td><td>Airy, Juicy, and Silky</td></tr>
                    <tr><td>Sweetness Level</td><td>Refreshingly Light (2.5/5)</td></tr>
                    <tr><td>Serving Size</td><td>500ml Box (Perfect for sharing or enjoying solo)</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The Sweet Serenity box is like a summer breeze in a jar.
                  Light, fresh, and beautifully balanced—it’s strawberry shortcake at its finest.”
                </blockquote>

                <p>
                  Ready to taste the sunshine? Add the
                  <strong>Sweet Serenity Strawberry Shortcake Box</strong> to your cart today
                  and enjoy the ultimate berry dessert experience.
                </p>
                """,
                11.99,
                35,
                "/product_img/StrawberryShortcake_Main.png",
                true
        ));

        // 15) Black Forest
        productRepository.save(new Product(
                "Black Forest",
                "Chocolate & cherry classic",
                """
                <h2>Enchanted Forest: The Signature Black Forest Dessert Box</h2>

                <p>
                  Step into a world of timeless indulgence with our
                  <strong>Enchanted Forest Black Forest Dessert Box</strong>. This luxurious dessert
                  reimagines the classic German <em>Schwarzwälder Kirschtorte</em> in a modern,
                  spoonable format that highlights its iconic combination of dark cocoa,
                  tart cherries, and delicate cream.
                </p>


                <h3>A Masterclass in Layering</h3>
                <ul>
                  <li><strong>The Midnight Sponge:</strong> A soft Dutch-processed cocoa sponge cake soaked lightly in a non-alcoholic cherry reduction, ensuring deep chocolate flavour and irresistible moisture.</li>
                  <li><strong>The Orchard Center:</strong> A vibrant layer of tart Morello cherries and ruby-red cherry compote that provides the perfect fruity contrast to the rich cocoa sponge.</li>
                  <li><strong>The Chantilly Cloud:</strong> Generous layers of fresh, lightly sweetened whipped cream that bring a silky texture and delicate sweetness.</li>
                  <li><strong>The Finishing Touch:</strong> A topping of elegant dark chocolate curls and glossy glacé cherries for a striking visual finish and satisfying chocolate snap.</li>
                </ul>


                <h3>Product Details</h3>

                <table>
                  <thead>
                    <tr><th>Feature</th><th>Description</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>Key Ingredients</td><td>Dutch Cocoa, Morello Cherries, Fresh Dairy Cream</td></tr>
                    <tr><td>Texture</td><td>Airy, Moist, and Silky</td></tr>
                    <tr><td>Sweetness Level</td><td>Sophisticated / Bittersweet Balance (3/5)</td></tr>
                    <tr><td>Serving Size</td><td>500ml Box (Ideal for sharing between 2, or 1 deep indulgence)</td></tr>
                  </tbody>
                </table>

                <blockquote>
                  “The perfect marriage of tart and sweet. It’s like the best parts of a
                  traditional bakery visit, captured in a sleek, modern box.”
                </blockquote>

                <p>
                  Experience the magic of the woods. Order your
                  <strong>Enchanted Forest Black Forest Box</strong> today and rediscover why this
                  legendary flavour combination has delighted dessert lovers for generations.
                </p>
                """,
                12.99,
                30,
                "/product_img/BlackForrest_Main.png",
                true
        ));

        userRepository.save(new User("admin@dessertbox.ie", "12345678", Role.ADMIN, "Tara", "Angeline"));
        userRepository.save(new User("test@example.com", "12345678", Role.CUSTOMER, "Jane", "Doe"));

        return "redirect:/";
    }
}