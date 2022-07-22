A text README file explaining your design. Your README file should give the graders an overview of what the purposes are for every class, interface, etc. that you include in your submission, so that they can quickly get a high-level overview of your code. It does not replace the need for proper Javadoc!

## Controller
Our controller contains the interface 'ImageController' and two classes `ImageControllerImpl` and `Main`.
The `ImageController` interface contains the method `perform` which allows the controller to be used.
The `ImageControllerImpl` class implements `ImageController` and represents the implementation that allows the user to write their commands, so specific functions can be executed. `ImageControllerImpl` contains the method `perform` and 11 classes (following the command design pattern). `ImageControllerImpl` has the following fields: a Readable `input` which represents the user input, a String array `commands` which represents all the commands the user inputs, an ImageModel `model` which represents the Image which the controller will be using, a HashMap `functions` which maps a String to the Runnable (which represents the different commands) and IImageView `view` which represents the view. The constructor takes in `input`, `view`, `model` and sets a new HashMap of the function name and function command.
The public method `perform` executes the functions which is called and throws an `IOException` when transmission fails and the command is unable to run.
`ImageControllerImpl` has the following command classes:
- `Load`: uses the built-in Runnable interface and runs the command which allows for the user to load the image.
- `Save`: uses the built-in Runnable interface and runs the command which allows for the user to save the image.
- `Brighten`: uses the built-in Runnable interface and runs the command which allows for the user to brighten the image with a given increment.
- `Darken`: uses the built-in Runnable interface and runs the command which allows for the user to darken the image with a given increment.
- `GreyscaleRed`: uses the built-in Runnable interface and runs the command which allows for the user to adjust the grayscale by only using red.
- `GreyscaleGreen`: uses the built-in Runnable interface and runs the command which allows for the user to adjust the grayscale by only using green.
- `GreyscaleBlue`: uses the built-in Runnable interface and runs the command which allows for the user to adjust the grayscale by only using blue.
- `Luma`: uses the built-in Runnable interface and runs the command which allows for the user to convert to grayscale by using Luma (equation given on assignment).
- `Value`: uses the built-in Runnable interface and runs the command which allows for the user to convert to grayscale by using Value (the maximum value of the three components for each pixel).
- `Intensity`, uses the built-in Runnable interface and runs the command which allows for the user to convert to grayscale by using Intensity (the average of the three components for each pixel).
- `Vertical`, uses the builtIn Runnable interface, that will allow us to flip the image vertically.
- `Horizontal`, uses the builtIn Runnable interface, that will allow us to flip the image horizontally

*Changes for Assignment 5*
`ImageControllerImpl` has the following new command classes:
- `Blur`: uses the built-in Runnable interface and runs the command which allows for the user to blur the image.
- `Sharpen`: uses the built-in Runnable interface and runs the command which allows for the user to sharpen the image.
- `Sepia`: uses the built-in Runnable interface and runs the command which allows for the user to apply the sepia filter on the image.
- `Greyscale`: uses the built-in Runnable interface and runs the command which allows for the user to apply the greyscale filter on the image.

*Changes / Additions for Assignment 6*
Our `ImageControllerImpl` now supports the extra credit step for partial image manipulation.
All command classes except `Load`, `Save`, `Vertical` and `Horizontal` check if there is an extra command. If there is it will call the mask function for that specific filter.
A new private method called `wrongDimensionMask` will render an error message if the mask image and orginal image do not have the same dimension.

Now our controller contains the class `InteractiveController` which implements the `ImageController` interface.
The `InteractiveController` class has the following fields: GraphicsInterface `view` represents the GUI, String[] `commands` represents the commands the user will input, int `counter` represents the counter (to parse through commands), ImageModel `model` which represents the model interface that will allow us to call all the image filter functions and a HashMap<String, Runnable> `function` which represents the filters that the user will be allowed to use.
The `InteractiveController` constructor takes in a view and model and this constructor will be used to show the updated images in the GUI. It also contains the HashMap values for the function names.
The private method `processCommand`, is able to process what the command is and performs the command on the image.
The public method `accept`, takes in a string input and finds the respective HashMap to know which function to call.
`InteractiveController` has the following command classes (similar to `ImageControllerImpl`):
- `Load`: uses the built-in Runnable interface and runs the command which allows for the user to load the image.
- `Save`: uses the built-in Runnable interface and runs the command which allows for the user to save the image.
- `Brighten`: uses the built-in Runnable interface and runs the command which allows for the user to brighten the image with a given increment.
- `Darken`: uses the built-in Runnable interface and runs the command which allows for the user to darken the image with a given increment.
- `GreyscaleRed`: uses the built-in Runnable interface and runs the command which allows for the user to adjust the grayscale by only using red.
- `GreyscaleGreen`: uses the built-in Runnable interface and runs the command which allows for the user to adjust the grayscale by only using green.
- `GreyscaleBlue`: uses the built-in Runnable interface and runs the command which allows for the user to adjust the grayscale by only using blue.
- `Luma`: uses the built-in Runnable interface and runs the command which allows for the user to convert to grayscale by using Luma (equation given on assignment).
- `Value`: uses the built-in Runnable interface and runs the command which allows for the user to convert to grayscale by using Value (the maximum value of the three components for each pixel).
- `Intensity`, uses the built-in Runnable interface and runs the command which allows for the user to convert to grayscale by using Intensity (the average of the three components for each pixel).
- `Vertical`, uses the builtIn Runnable interface, that will allow us to flip the image vertically.
- `Horizontal`, uses the builtIn Runnable interface, that will allow us to flip the image horizontally
- `Downscale`, uses the builtIn Runnable interface, that will downscale the image by an increment.

The `Main` class holds the `main` method. `Main` has the following fields: a Readable `readable` represents a new InputStreamReader which takes in user input, an Appendable `app` which appends the output to the console, an ImageModelImplementation `model` which instantiates a new ImageModelImplementation, an ImageView `view` which instantiates a new ImageView taking in an `app`, an ImageControllerImpl `controller` which instantiates a new ImageControllerImpl taking in a `readable`, `view` and a `model`. The `main` method will run the `perform` method in our controller.

*Changes for Assignment 5*
If the script file is not empty, it reads all the commands and executes it. But if the file is empty, then it will allow the user to use the console to change the image.

## Model
Our model is divided into three packages and contains the `ImageUtil` class:
`image`: contains the `Image` interface and `ImageImplementation` class.
The `Image` interface contains methods: `getImage`, `getImageWidth`, `getImageHeight`, `pixel` and `getMaxValue`.
The `ImageImplementation` class implements the `Image` interface and its methods. The first constructor takes in a String `filename` (which represents an Image) and it appends the RGB components of each pixel. The second constructor takes in a Pixel array `image` and an Integer `maxValue` and initializes fields `pixels`, `width`, `height` and `maxValue`. The third constructor takes in a Pixel array `image` and uses the second constructor to initialize its fields (`maxValue` is 255).
The public method `getImage`, returns the Pixel array which represents an Image.
The public method `getImageWidth`, returns the width of the Image.
The public method `getImageHeight`, returns the height of the Image.
The public method `getMaxValue`, returns the max value of the Image.
The public method `pixel`, returns the R, G and B components of a given pixel in a given `row` and `col`.

*Changes for Assignment 5*
The first constructor in the `ImageImplementation` class now supports JPG, PNG and BMP alongsides PPM.
For JPG, PNG and BMP it initializes the pixels uses a function called `loadBufferedImage`. Initializes the widgth and height using `getWidth()` and `getHeight()`.
The private static method `getWidth`, takes in a filename and inputs the width of that buffered image.
The private static method `getHeight`, takes in a filename and inputs the height of that buffered image.
Both `getHeight` and `getWidth` uses a in-built class called `BufferedImage`.
The private method `loadBufferedImage`, takes in a filename and creates a pixel 2d array `result` so that the image can be represented as pixels with the correct RGB components. Uses in-built classes called `ImageIO` and `BufferedImage`.

`modelImplementation`: contains the `ImageModel` interface and its implementation as well as `ImageFilterImplementation`.
The `ImageFilterImplementation` class has the following fields: an enum `MathChoice` to represent the different math operations `{ADD, MINUS}` and an enum `GreyScale` to represent the different GreyScale filters `{CLASSIC, INTENSITY, VALUE, RED, GREEN, BLUE}`.
The private method `clamp`, makes sure that the pixel value is between 0 and 255 (8-bit RGB scale max-value).
The protected method `createNewPixel`, creates a new pixel with a given integer for row and columns, an image, a filter and math choic. The switch cases `ADD` and `MINUS` allows us to brighten and darken the image respectively.
The protected method `applyFilter`, returns a new image with the passed filter (brighten or darken) applied.
The protected method `greyScale`, returns a new Image with chosen grayscale filter applied on the image using switch cases from the enum `GreyScale`.
The protected method `flipHorizontal`, returns the Image flipped horizontally.
The protected method `flipVertical`, returns the Image flipped vertically.

*Changes for Assignment 5*
To build more flexibility, a interface `ImageFilter` was added.
The `ImageFilter` interface has methods: `clamp`, `transform`, `createNewKernelPixel`, `getKernel`, ` createNewPixel`, `applyFilter`, `greyScale`, `flipHorizontal`, `flipVertical`.
These methods are present in the `ImageFilterImplementation` class.

In the `ImageFilterImplementation` class, the enum `MathChoice` to represent different math operations now has `{ADD, MINUS, MULTIPLY, TRANSFORM}`. And the enum `GreyScale` to represent the different GreyScale filters now is `{INTENSITY, VALUE, RED, GREEN, BLUE LUMA}`.
The private method `transform` takes in a 1D array `pixel` and 1D array `filter` and multiplies the filter 1D array to the pixel 1D array and returns a new double called `newPixel`.
The private method `createNewKernelPixel`, takes in a 2D array `kernel` and a 2D array `filter` and mulitiplies the 2D array `filter` with the `kernel` to create new pixels with RGB components. Returns a single `pixel`.
The private method `getKernel`, takes in a int `row`, int `column`, a 2D pixel array `image` and int `size`. Creates a new 2D pixel array `kernel` and captures RGB components within a given boundary. In order to calculate the boundary we use a local variable called `size` which could change boundary used to create the 2D pixel array `kernel`. If there is a `IndexOutOfBoundsException` the pixel will be created with the RGB components as all 0.
The protected method 'applyFilter', now supports blur and sharpen using `MUlTIPLY` which uses `createNewKernelPixel` and `getKernel` to calculate the pixels for the blur or sharpen image. It also supports sepia and greyscale using `TRANSFORM` which uses the `transform` helper method to initialize the RGB components.

*Changes / Additions for Assignmnet 6*
To help complete extra credit the interface `Imagefilter` interface now supports methods: `applyFilterMask` and `greyscaleMask`. These methods were also implemented in the `ImageFilterImplementation` clas.

In the `ImageFilterImplementation` class we added a new enum `FilterChoice` to represent the different filter options for mask images, to help u scomplete the extra credit. The choices are `{ SEPIA, GREYSCALE, GREYSCALERED, GREYSCALEGREEN, GREYSCALEBLUE, LUMA, VALUE, INTENSITY, SHARPEN, BLUR, DARKEN, BRIGHTEN }`
The private method `calcRGB`, allows us to calculate the RGB component of a pixel in the mapped location, after being changed by the increment size.
The public method `downscaleImage`, downscales an Image by a given increment, by resizing the image and getting its mapped RGB pixel value using a helper function called calcRGB. The maskImage and image need to be of same dimension.
The private method `isBlack`, allows to check whether a pixel at a given row and column is black (R = 255, G = 255, G = 255).
The public method `applyFilterMask`, will apply the filter to each pixel only where the mask applies. For this method the filters are sepia, greyscale, sharpen, blur, brighten and darken.
The public method `greyscaleMask`, will apply the filter to each pixel only where the mask applies. This method
specifically focuses on the greyscale filters.

The `ImageModel` interface has methods: `getRed`, `getGreen`, `getBlue`, `setImage`, `getImage`, `loadImage`, `saveImage`, `intensity`, `value`, `greyScaleRed`, `greyScaleGreen`, `greyScaleBlue`, `luma`, `brighten`, `darken`, `flipImageHorizontal`, `flipImageVertical` and `blackAndWhite`.
The `ImageModelImplementation` class implements the `ImageModel` interface and has the following fields: an Image `image` which is the image to be changed, a HashMap `map` which represents a HashMap of String to Image and an Image `newImage` which represents the post-edited, changed Image.The first constructor takes in an `image` and instantiates the image and a new HashMap. The second constructor instantiates a new HashMap.
The public method `getRed`, gets the red component value of a given pixel of an image.
The public method `getGreen`, gets the green component value of a given pixel of an image.
The public method `getBlue`, gets the blue component value of a given pixel of an image.
The public method `setImage`, maps a `image` to its String `name`.
The public method `getImage`, gets Image from a given String `name`.
The public method `loadImage`, loads the Image and maps the loaded Image to its new String `name`.
The public method `saveImage`, saves the Image and maps the saved `image_name` to saved Image.
The public method `intensity`, creates a new Image by applying the intensity greyscale filter and maps the `newImage` to a `dest_image_name`.
The public method `value`, creates a new Image by applying the value greyscale filter and maps the `newImage` to a `dest_image_name`.
The public method `greyScaleRed`, creates a new Image by applying the red greyscale filter and maps the `newImage` to a `dest_image_name`.
The public method `greyScaleGreen`, creates a new Image by applying the green greyscale filter and maps the `newImage` to a `dest_image_name`.
The public method `greyScaleBlue`, creates a new Image by applying the blue greyscale filter and maps the `newImage` to a `dest_image_name`.
The public method `flipImageHorizontal`, creates a new Image by flipping the image horizontally and maps the `newImage` to a `dest_image_name`.
The public method `flipImageVertical`, creates a new Image by flipping the image vertically and maps the `newImage` to a `dest_image_name`.

*Changes for Assignment 5*
The method `saveImage` now checks the extension and if it is PNG, JPG or BPM it uses the `saveBufferedImage` function. If an empty string is given for the `filename` it will throw a new IllegalArgumentException.
The public method `blur` takes in a String `imageName` and String `destImageName`, blurs the image using the given 2D array in the function called `blurFilter`.
The public method `sharpen` takes in a String `imageName` and String `destImageName`, blurs the image using the given 2D array in the function called `sharpenFilter`. `sharpen` and `blur` both use kernels.
The public method `toGreyScale`, takes in a String `imageName` and String `destImageName`. Uses the given 2D array `greyscale` to transform the image.
The public method `toSepia`, takes in a String `imageName` and String `destImageName`. Uses the given 2D array `sepia` to transform the image.
A private method `filterDarkenBrighten` will takes in an int `increment`. This will create a filter with the size of the image; each element in the integer filter array will be initialized as the increment.

`Pixel`: contains the `Pixel` interface and its implementation class `PixelImplementation`. The `PixelImplementation` interface has methods: `getRed`, `getGreen` and `getBlue`.
The `PixelImplementation` class implements the `Pixel` interface and has the following fields: an Integer `red` which represents a red component value, an Integer `green` which represents a green component value and an Integer `blue` which represents a blue component value. The constructor instantiates all these fields.
The public methods `getRed`, `getGreen` and `getBlue` return the respective red, green, blue values.

*Changes / Additions for Assignment 6*
To help complete extra credit the interface `ImageModel` interface now supports methods: `getPixelImage`, `getImageWidth`, `getImageHeight`, `getImageToBeShown`, `intensityMask`, `valueMask`, `greyscaleRedMask`, `greyscaleGreenMask`, `greyscaleBlueMask`, `lumaMask`, `brightenMask`, `darkenMask`, `blurMask`, `sharpenMask`, `greyscaleMask`, `sepiaMask` and `downscale`. These methods are present in the `ImageModelImplementation` class.

In the `ImageModelImplementation` class the public method `getPixelImage`, gets the pixel 2D array of an image's pixels by iterating through all the row and columns and getting their RGB values.
The public methods `getImageWidth` and `getImageHeight` get the integer value for this image's width and height respectively.
The public method `getImageToBeShown` retrieves an image and returns it.
The public method `intensityMask`, creates a new Image by applying the intensity greyscale filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `valueMask`, creates a new Image by applying the value greyscale filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `greyscaleRedMask`, creates a new Image by applying the greyscale red filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `greyscaleGreenMask`, creates a new Image by applying the greyscale green filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `greyscaleBlueMask`, creates a new Image by applying the greyscale blue filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `lumaMask`, creates a new Image by applying the greyscale blue filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `brightenMask`, creates a new Image by brightening the image only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `darkenMask`, creates a new Image by darkening the image only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `blurMask`, creates a new Image by blurring the image only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `sharpenMask`, creates a new Image by sharpening the image only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `greyscaleMask`, creates a new Image by applying the greyscale filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `sepiaMask`, creates a new Image by applying the sepia filter only to the masked pixels and maps the newImage to a `dest_image_name`.
The public method `downscale`, creates a new Image by downscaling the image and maps the newImage to a `dest_image_name`.

`ImageUtil`
*Changes for Assignment 5*
The  `ImageUtil` class will now be used to save the images. There are two save methods within this class; one would handle BufferedImages(png/jpg/bmp) and the other will handle ppm files.
The first  method is `saveBufferedImage`, takes in a 2D Pixel array `rgb`, `height`, `width` and `fileName`. Turns the pixels into a buffered image with the correct extension.This will be used for rgb/png/bmp files.
The second is a private class `Save` that has the following fields: a String `fileName` which represents the name the file will be saved as, a String `imageToBeSaved` which represents the name of the file and an Image `imageSaved` which represents the image that was saved as a file. The constructor instantiates `fileName`, `imageToBeSaved` and `imageSaved`. The private method `apply`, saves the RGB from the new saved ppm image.

## View
Our view contains the `IImageView` interface and its implementation class `ImageView`. The `IImageView` interface has methods: `toString` and `renderMessage`.
The `ImageView` class implements `IImageView` interface and has the following fields: an Appendable `appObject` which represents the Appendable object which will be displayed to the user and an ImageModel `image` which represents the Image.
The first constructor enforces the constraint that the Appendable object cannot be null and throws an IllegalArgumentException. Similarly with the second constructor, it enforces the constraint that the Model and Appendable cannot be null and throws an IllegalArgumentException.
The public method `toString`, returns a String that represents the commands that have taken place.
The public method `renderMessage`, appends the `toString` method and the commands.

*Changes / Additions for Assignment 6*
To support GUI, we added a `GraphicsInterface`. In this interface, we have methods: `makeVisible`,  `setCommand`,  `displayErrorMessage`, `displayImage`, `addHistogram` and `createTextBox`.

The class `ImageGraphics` implements the `GraphicsInterface` interface. In this class, we have the following fields: `histogramSave` (creates the histogram), `imageToCall` (records the image on the screen), `histogramPanel` (the panel where the histogram is displayed), `feauturePanel` (the main panel for the GUI), `menu` (to create the menu bar), `imageLabel` (to display the image), `fileSaveDisplay` (to show a save display to the users), and `commands` (to record what commands the user is performing).
The `ImageGraphics` constructor is used to initialize how the panels will be displayed; in other words, where the image and histogram will be placed. This will also add the menu bars; this constructor is used to place the labels correctly on the panels.
The private method `buildMenuBar`, represents the menu bar, so that the user can interact with the image editor.
The public method `addHistogram`,  takes in an image and uses the Histogram class to create a histogram for the image on the screen.
The private method `buildFileSubmenu`, creates the File submenu for this view. It contains options to load and save. For load and save, it will allow the user to choose (from their device) where they want to load from and save to.
The private method `buildFlipSubmenu`, contains the options to flip the image horizontally or vertically.
The private method `buildFilterSubmenu`, creates the Filter submenu for this view. It contains all the different filters (not flip functions), so the user can choose how they want to change the image.
The public method `createTextBox`, creates a JFrame, so the users can be asked how much they would like to downscale, brighten, or darken the image by. This allows the users to interact with the gui by determining how much they want the image to be changed.
The private method `buildImageDisplay`, builds the display of the image by adding the dimension, its location, and ability for the panel to scroll.
The public method `makeVisible`, will be used to make the panels visible.
The public method `setCommand`, takes in a command, and changes the image using the type of command stated.
The public method `displayImage`, displays the image on the panel.
The public method `displayErrorMessage`. displays the error message, when the user takes an action that is incorrect.

To display the Histogram, we created the class `Histogram` that extends a JLabel. This uses an Image field and private map fields `red`, `green`, `blue` and `intensity`. Each map represents the respective color components of the given image.  
The constructor takes in an image, and initializes the image so the image can be updated. This class uses the following methods:
The public method `replaceImage` is used to change the histogram as the image changes. This makes sure that the present histogram is updated, rather than creating a new one.
The private method `getColorHistogram` updates the histogram data, as it checks the amount of red, green, blue, intensity components of the given image.
The public inbuilt method `paintComponent` takes in a Graphics, and it allows us to use in-build functions such as drawLine to draw the histogram.
The private method `getMaxValue` gets the max value of the red, green, blue and intensity maps. This will be used to scale the histogram to fit onto the axis of the histogram on the screen.
The private method `findMaxValue` compares the max value for all four color maps and returns the max from those numbers. This will be used to scale the image, so we have a histogram that fits the JPanel screen.
The public method `getPreferredSize` overrides any size command for histogram, so we can have initialize the dimension of the histogram.

## How to run our program
1. To load our image file, type:
   `load res/toast.ppm loaded`
2. To execute a command:
   `command_name loaded new_image_name`
   - The command names are: `brighten`, `darken`, `greyscale`, `greyscale-red`, `greyscale-green`, `greyscale-blue`, `greyscale-value`, `greyscale-intensity`, `greyscale-luma`, `blur` `sharpen`, `sepia`, `horizontal` and `vertical`.
     **Now with `downscale`.**
   - remember that when using `brighten`, `darken` or `downscale`, an increment must be placed first (`command_name increment-you-wish loaded new_image_name`)
   - repeat this step as many times as you want, the `<new_image_name>` must be used for the second argument and so forth. The `new_image_name` will change after each command.
3. To save the edited image:
   `save new_image_name file_name_you_want`

*Changes for Assignment 6*
To apply a filter on a masked image the running of the program change slightly.
1. To load mask image, type:
   `load res/squareTriangle.png mask`
2. To load image, type
   `load res/flower.png flower`
3. To execute a command:
   `command_name flower mask new_image_name`
   - The command names are: `brighten`, `darken`, `greyscale`, `greyscale-red`, `greyscale-green`, `greyscale-blue`, `greyscale-value`, `greyscale-intensity`, `greyscale-luma`, `sepia`, `blur` and `sharpen`.
   - remember that when using `brighten` and `darken` an increment must be placed first (`command_name increment-you-wish flower mask new_image_name`)
   - repeat this step as many times as you want, the `<new_image_name>` must be used for the second argument and so forth. The `new_image_name` will change after each command.
4. To save the edited image:
   `save new_image_name file_name_you_want`

EXTRA CREDIT:
*Downscale*
We created methods in our `ImageFilterImplementation` and `ImageModelImplementation` classes, that will handle the calculations of creating a downscaled Image. More specifically, the methods `calcRGB` and `downscaleImage` from the `ImageFiterImplementation` will calculate the new downscale image. The method `downscale` in the `ImageModelImplementation` will be called in the controller (for GUI and console) to ensure that an image can be changed by a given number(given by the user).
*Partial Image Manipulation*
In our `ImageFilterImplementation` we created the method `isBlack` that would check if a given pixel in the maskImage is a blackpixel. If it is, then it will use those row and col, and apply filter to the original image (to the pixels in the black row and col from the mask image). If not, it will keep the image pixel rgb components the same. We created `applyFilterMask` when we have to change the image by a filter that is already given(will be used for the any filters that are not greyscale). For greyscale filters, we will use 'greyscaleMask' so we can calculate the new color (for specific row and col) and add it to the new image. In our `ImageModelImplementation` we made new functions that use a mask image. In our controllers, when an extra command is added, we can use the mask functions to partially alter the image. These functions are only called in `ImageControllerImpl` as we were asked to not make this work on the GUI.

Citation for Image used:
The toast image is our personal image. Owner: Rei Masuya.

*Additions for Assignment 5*
The flower image is our personal image. Owner: Rei Masuya.
The selfie image is our personal image. Owner: Varshani Haldia
The pizza image is our personal image. Owner: Rei Masuya.
