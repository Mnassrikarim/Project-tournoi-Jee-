<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="metier.Joueur" %>
<%
List<Joueur> joueurList = (List<Joueur>) request.getAttribute("joueurList");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tournoi - Bootstrap 5 CSS Template</title>

    <!-- CSS FILES -->
    <link rel="preconnect" href="https://fonts.googleapis.com">

    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@100;200;400;700&display=swap" rel="stylesheet">

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/bootstrap-icons.css" rel="stylesheet">

    <link href="css/templatemo-festava-live.css" rel="stylesheet">
       <link href="css/temp.css" rel="stylesheet">

    <!--

TemplateMo 583 Tournoi

https://templatemo.com/tm-583-festava-live

-->
</head>

<body>
    <main>
        <nav class="navbar navbar-expand-lg">
            <div class="container">
                <a class="navbar-brand" href="index.html">
                    Tournoi
                </a>

                <a href="ticket.html" class="btn custom-btn d-lg-none ms-auto me-4">Buy Ticket</a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav align-items-lg-center ms-auto me-lg-5">
                          <li class="nav-item">
                            <a href="home">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#section_2">About</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/equipeList">Equipes</a>
                        </li>
                        

                        <li class="nav-item">
                           <a class="nav-link" href="<%= request.getContextPath() %>/joueurList">Joueurs</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/entraineurList">Entraineurs</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link click-scroll" href="#section_6">Contact</a>
                        </li>
                    </ul>
                    <div class="d-flex">
                    <a href="ticket.html" class="d-flex"><i class="about-text-icon bi-person"></i></a>
                </div>
                </div>
            </div>
        </nav>
        
        
           <section class="hero-section" id="section_1">
            <div class="section-overlay"></div>
            <div class="container d-flex justify-content-center align-items-center">
                <div class="row">

                    <div class="col-12 mt-auto mb-5 text-center">
                        <small>Tournoi Presents</small>

                        <h1 class="text-white mb-5">Mes joueurs</h1>

                        <a class="btn custom-btn smoothscroll" href="#aj_2">Let's begin</a>
                    </div>
                </div>
            </div>
            
            <div class="video-wrap">
                <video autoplay="" loop="" muted="" class="custom-video" poster="" width="500" height="50%">
                    <source src="video/videoplayback2.mp4" type="video/mp4">

                    Your browser does not support the video tag.
                </video>
            </div>
        </section>
          <style>
          #section_44 {
          background-image: url('images/g3.jpg');
          }
          </style>
    <section class="schedule-section section-padding" id="section_44">
            <div class="container">
                <div class="row">

                    <div class="col-12 text-center">
                        <h2 class="text-white mb-4">Tables joueurs</h1>

                            <div class="table-responsive">

    <table class="schedule-table table">
        <thead>
            <tr>
                <th scope="col">Image</th>
                <th scope="col">ID</th>
                <th scope="col">Nom</th>
                <th scope="col">Prénom</th>
                
            </tr>
        </thead>
        <tbody>
            <% if (joueurList != null && !joueurList.isEmpty()) { %>
                <% for (Joueur joueur : joueurList) { %>
                    <tr>
                    <td class="image-column">
                    <img src="<%= joueur.getImage_url() %>" class="player-image">
                    </td>
                        <td class="center"><%= joueur.getJoueurId() %></td>
                        <td class="center"><%= joueur.getNom() %></td>
                        <td class="center"><%= joueur.getPrenom() %></td>
                    </tr>
                <% } %>
            <% } else { %>
                <tr>
                    <td class="center" colspan="8">Aucun joueur trouvé.</td>
                </tr>
            <% } %>
        </tbody>
    </table>
  <style>
    .player-image {
        width: 70%; /* Adjust the desired width here */
        height: 50%;
    }

    .image-column {
        width: 70%;
          height: 50%;
         /* Adjust the desired width here */
    }
     .center {
        text-align: center;
        font-size: 15px;
         text-decoration: underline;
          color: orange;
            text-transform: uppercase;
    }
</style>
      <a class="link-fx-1 color-contrast-higher mt-4" href="<%= request.getContextPath() %>/equipeList">
                                <span>Return </span>
                                <svg class="icon" viewBox="0 0 32 32" aria-hidden="true">
                                    <g fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round">
                                        <circle cx="16" cy="16" r="15.5"></circle>
                                        <line x1="10" y1="18" x2="16" y2="12"></line>
                                        <line x1="16" y1="12" x2="22" y2="18"></line>
                                    </g>
                                </svg>
                            </a>
                                 </div>
                         
                    </div>
                </div>
            </div>
        </section>
     </main>    
    

    <footer class="site-footer">
        <div class="site-footer-top">
            <div class="container">
                <div class="row">

                    <div class="col-lg-6 col-12">
                        <h2 class="text-white mb-lg-0">Tournoi</h2>
                    </div>

                    <div class="col-lg-6 col-12 d-flex justify-content-lg-end align-items-center">
                        <ul class="social-icon d-flex justify-content-lg-end">
                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link">
                                    <span class="bi-twitter"></span>
                                </a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link">
                                    <span class="bi-apple"></span>
                                </a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link">
                                    <span class="bi-instagram"></span>
                                </a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link">
                                    <span class="bi-youtube"></span>
                                </a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link">
                                    <span class="bi-pinterest"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">

                <div class="col-lg-6 col-12 mb-4 pb-2">
                    <h5 class="site-footer-title mb-3">Links</h5>

                    <ul class="site-footer-links">
                        <li class="site-footer-link-item">
                            <a href="#" class="site-footer-link">Home</a>
                        </li>

                        <li class="site-footer-link-item">
                            <a href="#" class="site-footer-link">About</a>
                        </li>

                        <li class="site-footer-link-item">
                            <a href="#" class="site-footer-link">Artists</a>
                        </li>

                        <li class="site-footer-link-item">
                            <a href="#" class="site-footer-link">Schedule</a>
                        </li>

                        <li class="site-footer-link-item">
                            <a href="#" class="site-footer-link">Pricing</a>
                        </li>

                        <li class="site-footer-link-item">
                            <a href="#" class="site-footer-link">Contact</a>
                        </li>
                    </ul>
                </div>

                <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
                    <h5 class="site-footer-title mb-3">Have a question?</h5>

                    <p class="text-white d-flex">
                        <a href="mailto:hello@company.com" class="site-footer-link">
                            hello@company.com
                        </a>
                    </p>
                </div>

                <div class="col-lg-3 col-md-6 col-11 mb-4 mb-lg-0 mb-md-0">
                    <h5 class="site-footer-title mb-3">Location</h5>

                    <p class="text-white d-flex mt-3 mb-2">
                        Silang Junction South, Tagaytay, Cavite, Philippines</p>
                </div>
            </div>
        </div>

        <div class="site-footer-bottom">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 col-12 mt-5">
                        <p class="copyright-text">Copyright © 2023 Tournoi Company</p>
                        <p class="copyright-text">Distributed by: Karim mnassri</p>
                    </div>

                    <div class="col-lg-8 col-12 mt-lg-5">
                        <ul class="site-footer-links">
                            <li class="site-footer-link-item">
                                <a href="#" class="site-footer-link">Terms &amp; Conditions</a>
                            </li>

                            <li class="site-footer-link-item">
                                <a href="#" class="site-footer-link">Privacy Policy</a>
                            </li>

                            <li class="site-footer-link-item">
                                <a href="#" class="site-footer-link">Your Feedback</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!--

T e m p l a t e M o

-->

    <!-- JAVASCRIPT FILES -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    <script src="js/click-scroll.js"></script>
    <script src="js/custom.js"></script>

</body>
</html>

