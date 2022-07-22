## Commands
### To load the image
This step *must* be done at the beginning of editing an image (only once per image).
Type: `load <imagefilename> <nameX>` and then press enter.
`load` must be typed first.
<imagefilename> must be typed correctly and include the folder, for example `res/koala.ppm`

*Changes for Mask Images*
To support image masking two images must be loaded.
The above steps must be repeated twice. Ensure the names of <nameX> are different for the image and mask image.

### To apply a filter
Must be done after typing the load command.
Type `<filtername> <nameX> <nameY>` and then press enter.
! For `brighten`, `darken` and `downscale` the following must be typed:
`<filtername> <increment_amount> <nameX> <nameY>`

The possible filternames are:
- `brighten`: brightens the image with a given increment.
- `darken`: darkens the image with a given increment.
- `greyscale-red`: adjusts the greyscale by only using red.
- `greyscale-green`: adjusts the greyscale by only using green.
- `greyscale-blue`: adjusts the greyscale by only using blue.
- `greyscale-luma`: converts to greyscale by using Luma
- `greyscale-value`: converts to greyscale by using Value (the maximum value of the three components for each pixel).
- `greyscale-intensity`: converts to greyscale by using Intensity (the average of the three components for each pixel).
- `blur`:  blurs the image.
- `sharpen`: sharpens the image.
- `sepia`: applies the sepia filter on the image.
- `greyscale`: applies the greyscale filter on the image.
- `horiztonal`: flips image horizontally
- `vertical`: flips image vertically
  More than one filter can be applied, the image name has to change per filter applied.
- `downscale`: downscales the image by a given increment.

*Changes for Assignment 6*
Now that we have the image and mask image, we type:
`<filtername> <nameX> <nameMask> <nameY>` and then press enter.
! For `brighten` and `darken` it would look like
`<filtername> <increment_amount> <nameX> <nameMask> <nameY>`

### To save the image
Must be done after applying filter(s).
The `<nameZ>` must be the latest image name of the last filter applied.
Type: `save <nameZ> <filename>.extension` and then press enter.
The image should be saved to the original image folder.
The supported extensions are: `ppm`, `jpg`, `png`, `bmp`.
`save` must be typed first.

### Examples
Applying serpia and then horizontally flipping an image.
`load res/flower.png flower`
`sepia flower flower_sepia`
`horizontal flower_sepia flower_sepia_hori`
`save flower_sepia_hori newFlower.jpg`

Darkening image.
`load res/flower.png flower`
`darken 150 flower flower_dark`
`save flower_dark newFlower.bmp`

Downscaling image
`load res/flower.png flower`
`downscale 0.5 flower small_Flower`
`save small_flower downscaleFlower.png`

Bluring a masked image.
`load res/blackSquare.png mask`
`load res/flower.png flower`
`blur flower mask blur_Flower`
`save blurFlower blurMaskedFlower.png`

Brightening a masked image.
`load res/blackSquare.png mask`
`load res/flower.png flower`
`brighten 40 flower mask bright_flower`
`save bright_flower brightMaskedFlower.jpg`

## How to use our GUI
### To load an Image
To load an Image into the program, in the upper left corner go to **File** -> **Load Picture**.
Now you are able to select an image from anywhere on your computer.
Once loaded the image should show up on the left panel and the histogram should show up on the right.

### To apply a filter
To apply filters head to the upper left corner to **Filter** and pick the filter you want to apply.
For Brighten, Darken and Downscale, a pop-up window will prompt you to enter a value. For brighten and darken this will be the integer value by which the image is brightened and darkened by respectively. For downscale this will be the double decimal value by which the image will be downscaled.
To flip the image go to **Flip** and pick Horizontal or Vertical to flip the image.
The histogram on the right should keep changing as filters are applied.

### To save the image
To save the Image, head to the upper left corner and go to **File** -> **Save Picture**. In the text box to input the destImageName make sure to add the extension (.ppm, .png, .jpg, .bmp)