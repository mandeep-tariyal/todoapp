<%-- 
    Document   : footer
    Created on : Sep 22, 2020, 4:52:06 PM
    Author     : Mandeep
--%>
 <style>

    .footer{
          position: absolute;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 100px;
  background: 
  /* color overlay */ 
    linear-gradient(
      rgba(240, 212, 0, 0.45), 
      rgba(0, 0, 0, 0.45)
    ),
    /* image to overlay */
    url(http://images.cdn.fotopedia.com/_avPIZmqM3w-7z161LH_268-hd.jpg);
    }

</style>

<footer class="footer font-small text-center">
    
    <div>
        <a href="<%= request.getContextPath()%>/about.jsp" class="text-center" style="color: black"> Todo App</a>
  </div>
</footer>



